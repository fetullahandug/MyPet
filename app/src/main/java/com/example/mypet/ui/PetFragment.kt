package com.example.mypet.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mypet.data.model.Male
import com.example.mypet.data.model.Type
import com.example.mypet.databinding.FragmentPetBinding

class PetFragment : Fragment() {
    private val viewmodel: SharedViewModel by activityViewModels()
    private lateinit var binding: FragmentPetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var petIndex: Int = -1

        arguments?.let {
            petIndex = it.getInt("petIndex")
        }

        viewmodel.initializePetSelection(petIndex)

        if (viewmodel.currentPet.value != null) {
            binding.ivPetImageDetail.setImageResource(viewmodel.currentPet.value!!.imageResource!!)
            binding.tvPetNameDetail.text = viewmodel.currentPet.value!!.name!!
            binding.tvPetAgeDetail.text = "(" + viewmodel.currentPet.value!!.age + ")"

            if (viewmodel.currentPet.value!!.sex == Male.MALE) {
                binding.tvPetMaleDetail.text = "MALE"
            } else if (viewmodel.currentPet.value!!.sex == Male.FEMALE) {
                binding.tvPetMaleDetail.text = "FEMALE"
            }

            when (viewmodel.currentPet.value!!.type) {
                Type.CAT -> binding.tvPetTypeDetail.text = "CAT"
                Type.DOG -> binding.tvPetTypeDetail.text = "DOG"
                Type.BIRD -> binding.tvPetTypeDetail.text = "BIRD"
                else -> binding.tvPetTypeDetail.text = "UNKNOWN"
            }

            binding.btnBack.setOnClickListener {
                findNavController().navigate(PetFragmentDirections.actionPetFragmentToPetlistFragment())
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewmodel.resetPet()
    }
}