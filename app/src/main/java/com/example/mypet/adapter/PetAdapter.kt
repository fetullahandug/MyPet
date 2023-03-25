package com.example.mypet.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mypet.data.model.Pet
import com.example.mypet.databinding.PetItemBinding
import com.example.mypet.ui.PetlistFragmentDirections

class PetAdapter(private val petlist: List<Pet>) : RecyclerView.Adapter<PetAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: PetItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = PetItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val pet = petlist[position]

        holder.binding.ivPetImage.setImageResource(pet.imageResource!!)
        holder.binding.tvPetName.text = pet.name

        holder.itemView.setOnClickListener {
            holder.itemView.findNavController().navigate(PetlistFragmentDirections.actionPetlistFragmentToPetFragment(position))
        }
    }

    override fun getItemCount(): Int {
        return petlist.size
    }
}