package com.naStipe.calculator.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ToDoItem::class], version = 1)
abstract class TodoDatabase: RoomDatabase() {
    abstract fun todoDao(): ToDoDao
}