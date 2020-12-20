package com.example.listchoiceapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.listchoiceapp.data.Items
import com.example.listchoiceapp.repository.UserRepository
import com.example.listchoiceapp.room.UserDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {

    // se inicializa siempre f de getData y el respositorio
    val readAllData: LiveData<List<Items>>
    private val repository: UserRepository

    init { // inicializa la conexion de la base de datos con getdata del repositorio
        val userDao = UserDatabase.getDatabase(
            application
        ).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }
    //-------funciones del repositorio con coroutines-----------------------------------------------------------
    fun addUser(items: Items){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(items)
        }
    }


    fun deleteUser(items: Items){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUser(items)
        }
    }



}