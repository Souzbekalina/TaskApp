package com.alina.taskapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id:Int?=null,
    var title:String?=null,
    var desk:String?=null,


):java.io.Serializable
