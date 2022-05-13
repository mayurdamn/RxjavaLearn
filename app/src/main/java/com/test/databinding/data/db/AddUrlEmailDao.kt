package com.test.databinding.data.db

import androidx.room.*
import androidx.room.Dao

@Dao
interface AddUrlEmailDao {
    @Query("SELECT * FROM send_email")
    fun getAll(): List<AddUrlEmailModel>

    @Insert
    suspend fun insertRecord(record: AddUrlEmailModel) :Long

    @Delete
    suspend fun deleteRecord(record: AddUrlEmailModel):Int

     @Update
    suspend fun updateRecord(record: AddUrlEmailModel) : Int

}