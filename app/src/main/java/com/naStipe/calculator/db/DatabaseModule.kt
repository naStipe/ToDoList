package com.naStipe.calculator.db

import android.content.Context
import androidx.room.Room
import com.naStipe.calculator.PersistentModule

class DatabaseModule(context: Context) : PersistentModule {

    private val dao: ToDoDao

    init {

        val db = Room.databaseBuilder(context, TodoDatabase::class.java, "todos").build()
        dao = db.todoDao()
    }


    override fun getItems(): Collection<String> {
        val listOfTodos = dao.getAllItems()
        return listOfTodos.map { todoItem ->
            return@map todoItem.value
        }
    }

    override fun addItem(newItem: String) {
        dao.addItem(ToDoItem(newItem))
    }
}