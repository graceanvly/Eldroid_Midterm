package com.velayo.animal.midterm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.velayo.animal.midterm.databinding.RowBlockedLayoutBinding

class BlockedAnimalsAdapter(
    private val blockedAnimals: MutableSet<String>,
    private val onUnblockAnimalClick: (String) -> Unit
) : RecyclerView.Adapter<BlockedAnimalsAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: RowBlockedLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(blockedAnimalName: String) {
            binding.blockedAnimalName.text = blockedAnimalName

            // Set up a click listener for the "Unblock" button
            binding.unblockButton.setOnClickListener {
                onUnblockAnimalClick(blockedAnimalName)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RowBlockedLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(blockedAnimals.elementAt(position))
    }

    override fun getItemCount(): Int {
        return blockedAnimals.size
    }
}
