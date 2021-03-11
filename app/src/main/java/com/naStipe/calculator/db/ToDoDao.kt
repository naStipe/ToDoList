package com.naStipe.calculator.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ToDoDao {

    @Query(value = "SELECT * FROM todoitem")
    fun getAllItems(): List<ToDoItem>

    @Insert
    fun addItem(newItem: ToDoItem)
}