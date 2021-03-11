package com.naStipe.calculator.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDoItem(
    @ColumnInfo(name = "value") var value: String
) {
    @PrimaryKey(autoGenerate = true) var index: Int = 0 /* <-- это уникальный индекс объекта в базе
                                                            данных; благодаря параметру autoGenerate,
                                                            он будет сгенерирован автоматически */
}