package com.example.internettime

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "task_table")
class Task(@PrimaryKey @ColumnInfo(name = "name") val name: String){

}
