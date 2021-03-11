package com.naStipe.calculator

interface PersistentModule {
    fun getItems(): Collection<String>
    fun addItem(newItem: String)

}