package com.example.mypet.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mypet.data.Repository
import com.example.mypet.data.model.Pet

class SharedViewModel : ViewModel() {

    private val repository = Repository()

    private var _petList = MutableLiveData(repository.loadPets())
    val petList: LiveData<List<Pet>>
        get() = _petList

    private var _currentPet = MutableLiveData<Pet?>()
    val currentPet: LiveData<Pet?>
        get() = _currentPet

    init {
        repository.setPetImageResources()
    }

    fun initializePetSelection(petIndex: Int) {
        if(petIndex >= 0) {
            _currentPet.value = _petList.value!![petIndex]
        }else {
         Log.i("IndexNotFound", "Negative PetIndex Found!\nPet will not be setted!")
        }
    }

    fun resetPet() {
        _currentPet.value = null
    }

}