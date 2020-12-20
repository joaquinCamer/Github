package com.example.listchoiceapp.repository

import androidx.lifecycle.LiveData
import com.example.listchoiceapp.data.Items
import com.example.listchoiceapp.room.UserDao

class UserRepository(private val userDao: UserDao) {

    //f solo se usan en view model, ej: UserRepository. readAllData()
    val readAllData: LiveData<List<Items>> = userDao.readAllData()

    suspend fun addUser(items: Items){
        userDao.addUser(items)
    }


    suspend fun deleteUser(items: Items){
        userDao.deleteUser(items)
    }


}