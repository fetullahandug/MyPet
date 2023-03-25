package com.example.mypet.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mypet.R
import com.example.mypet.data.model.Male
import com.example.mypet.data.model.Pet
import com.example.mypet.data.model.Type

class Repository {
    private var _petList = MutableLiveData<List<Pet>>(loadPets())
    val petList: LiveData<List<Pet>>
        get() = _petList

    init {
        setPetImageResources()
    }

    fun loadPets() : List<Pet> {
        return listOf(
            Pet("Pamuk", 3, Type.CAT, Male.MALE, R.drawable.cat_male),
            Pet("Doggy", 12, Type.DOG, Male.MALE, R.drawable.dog_male),
            Pet("Pipi", 1, Type.CAT, Male.FEMALE, R.drawable.cat_female)
        )
    }

    fun setPetImageResources() {
        for(pet in _petList.value!!) {
            if(pet.sex == Male.MALE && pet.type == Type.DOG) {
                pet.imageResource = R.drawable.dog_male
            }else if(pet.sex == Male.FEMALE && pet.type == Type.DOG) {
                pet.imageResource = R.drawable.dog_female
            }else if(pet.sex == Male.MALE && pet.type == Type.CAT) {
                pet.imageResource = R.drawable.cat_male
            }else if(pet.sex == Male.FEMALE && pet.type == Type.CAT) {
                pet.imageResource = R.drawable.cat_female
            }
        }
    }
}