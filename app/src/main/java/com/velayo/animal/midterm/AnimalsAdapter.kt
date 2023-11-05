package com.velayo.animal.midterm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.velayo.animal.midterm.databinding.RowLayoutBinding

class AnimalsAdapter (private val animalList: List<MyString>, private val onAnimalClick:(MyString)-> Unit) :
        RecyclerView.Adapter <AnimalsAdapter.ViewHolder>() {

            data class MyString(val animalName: String, val animalDesc: String)

            inner class ViewHolder(private val binding: RowLayoutBinding): RecyclerView.ViewHolder(binding.root){
                fun bind(animal:MyString) {
                    with(binding) {
                        nameText.text = animal.animalName
                    }

                    binding.root.setOnClickListener{
                        onAnimalClick(animal)
                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowLayoutBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(animalList[position])
    }

    override fun getItemCount(): Int {
        return animalList.size
    }

}