package com.test.databinding.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "send_email")
data class AddUrlEmailModel(
   @PrimaryKey(autoGenerate = true) val _id: Int? = null,
   @ColumnInfo(name = "email") var email: String="",
   @ColumnInfo(name = "url") var url:String="",
   @ColumnInfo(name = "issendmail") var issendmail :Boolean=false,
   @ColumnInfo(name = "next_call_in") var next_call_in: Int? = null,
   @ColumnInfo(name = "last_status") var last_status : String="",
   @ColumnInfo(name = "isadded") var isadded: Boolean=false
)