package com.naStipe.calculator

import android.content.Context
import android.content.Context.MODE_PRIVATE
import androidx.core.content.edit

const val STRING_SET = "String_Set"

class PrefsModule(val context: Context) : PersistentModule {


    override fun getItems(): MutableSet<String> {
        val prefs = context.getSharedPreferences("MyPrefs", MODE_PRIVATE)
        return (prefs.getStringSet(STRING_SET, emptySet()) ?: emptySet()).toMutableSet()
    }

    override fun addItem(newItem: String) {
        val prefs = context.getSharedPreferences("MyPrefs", MODE_PRIVATE)

        val tempPrefs = getItems().toMutableSet()

        tempPrefs.add(newItem)

        prefs.edit {
            putStringSet(STRING_SET, tempPrefs)
        }
    }

}
