package com.naStipe.calculator

interface PersistentModule {
    fun getItems(): MutableSet<String>
    fun addItem(newItem: String)

}