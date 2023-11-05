package com.velayo.animal.midterm

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.velayo.animal.midterm.databinding.ActivityAnimalDetailsBinding

class AnimalDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnimalDetailsBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        val animalName = intent.getStringExtra("NAME_PARAMS")
        val animalDesc = intent.getStringExtra("DESC_PARAMS")

        binding.animalNameDetail.text = animalName
        binding.animalDescDetail.text = animalDesc

        binding.blockBtn.setOnClickListener {
            blockAnimal(animalName)
            val blockedAnimals = sharedPreferences.getStringSet("blockedAnimals", HashSet())?.toSet()
            updateAnimalList(blockedAnimals)
            finish()
        }

    }

    private fun blockAnimal(animalName: String?) {
        if (animalName != null) {
            val blockedAnimals = sharedPreferences.getStringSet("blockedAnimals", HashSet())?.toMutableSet()
            blockedAnimals?.add(animalName)

            val sharedPreferencesEditor = sharedPreferences.edit()
            sharedPreferencesEditor.putStringSet("blockedAnimals", blockedAnimals)
            sharedPreferencesEditor.apply()

            updateAnimalList(blockedAnimals)
            finish()
        }
    }

    private fun updateAnimalList(updatedBlockedAnimals: Set<String>?) {
        val intent = Intent(this, AnimalNamesActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("blockedAnimals", updatedBlockedAnimals?.toTypedArray())
        startActivity(intent)
    }


}




