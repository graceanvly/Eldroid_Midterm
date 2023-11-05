package com.velayo.animal.midterm

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.velayo.animal.midterm.databinding.ActivityManageBlockBinding

class ManageBlockActivity : AppCompatActivity() {
    private lateinit var binding: ActivityManageBlockBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManageBlockBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        val blockedAnimals = sharedPreferences.getStringSet("blockedAnimals", HashSet())?.toMutableSet()

        val adapter = BlockedAnimalsAdapter(blockedAnimals ?: mutableSetOf()) { unblockedAnimalName ->
            unblockAnimal(unblockedAnimalName)
            updateAnimalList()
        }


        with(binding.blockedAnimalsRecyclerView) {
            layoutManager = LinearLayoutManager(this@ManageBlockActivity)
            this.adapter = adapter

        }
        val backButton = binding.backButton
        backButton.setOnClickListener {
            navigateToAnimalNamesActivity()
        }
    }


    private fun unblockAnimal(unblockedAnimalName: String?) {
        if (unblockedAnimalName != null) {
            val blockedAnimals = sharedPreferences.getStringSet("blockedAnimals", HashSet())?.toMutableSet()
            blockedAnimals?.remove(unblockedAnimalName)

            val sharedPreferencesEditor = sharedPreferences.edit()
            if (blockedAnimals != null) {
                sharedPreferencesEditor.putStringSet("blockedAnimals", blockedAnimals)
                sharedPreferencesEditor.apply()
            }

            finish()
        }
    }


    private fun updateAnimalList() {
        val intent = Intent(this, AnimalNamesActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
    private fun navigateToAnimalNamesActivity() {
        val blockedAnimalsSet = sharedPreferences.getStringSet("blockedAnimals", HashSet())?.toSet() ?: emptySet()
        val intent = Intent(this, AnimalNamesActivity::class.java)
        intent.putExtra("blockedAnimals", blockedAnimalsSet.toTypedArray())
        setResult(RESULT_OK, intent)
        finish()
    }


}
