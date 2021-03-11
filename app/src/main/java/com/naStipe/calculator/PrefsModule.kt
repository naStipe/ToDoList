package com.naStipe.calculator

import android.content.Context
import android.content.Context.MODE_PRIVATE
import androidx.core.content.edit
import java.lang.annotation.Inherited

const val STRING_SET = "String_Set"

class PrefsModule(context: Context) : PersistentModule {

    private val prefs = context.getSharedPreferences("MyPrefs", MODE_PRIVATE)

    override fun getItems(): MutableSet<String> {
        return (prefs.getStringSet(STRING_SET, emptySet()) ?: emptySet()).toMutableSet()
    }

    override fun addItem(newItem: String) {
        val tempPrefs = getItems().toMutableSet()

        tempPrefs.add(newItem)

        prefs.edit {
            putStringSet(STRING_SET, tempPrefs)
        }
    }

}
