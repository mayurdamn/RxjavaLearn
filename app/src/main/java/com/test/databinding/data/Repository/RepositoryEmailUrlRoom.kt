package com.test.databinding.data.Repository

import com.test.databinding.data.db.AddUrlEmailDao
import com.test.databinding.data.db.AddUrlEmailModel

class RepositoryEmailUrlRoom(var daoUrl :AddUrlEmailDao) {
    val daoObj = daoUrl.getAll()

    suspend fun insert(record: AddUrlEmailModel): Long {
        return daoUrl.insertRecord(record)
    }

    suspend fun update(record: AddUrlEmailModel): Int {
        return daoUrl.updateRecord(record)
    }

    suspend fun delete(record: AddUrlEmailModel): Int {
        return daoUrl.deleteRecord(record)
    }
}