package com.example.listchoiceapp.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.listchoiceapp.data.Items

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(items: Items)


    @Delete
    suspend fun deleteUser(items: Items)


    @Query("SELECT * FROM tabla ORDER BY materia ASC")
    fun readAllData(): LiveData<List<Items>>

}
// suspend se desprende de corutines