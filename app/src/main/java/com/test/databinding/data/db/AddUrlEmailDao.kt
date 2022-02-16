package com.test.databinding.data.db

import androidx.room.*
import androidx.room.Dao

@Dao
interface AddUrlEmailDao {
    @Query("SELECT * FROM send_email")
    fun getAll(): List<AddUrlEmailModel>

    @Insert
     fun insert(record: AddUrlEmailModel)

    @Delete
     fun delete(record: AddUrlEmailModel)

     @Update
     fun updateRecord(record: AddUrlEmailModel)

}