package com.alina.taskapp.data.local.database

import androidx.room.*
import com.alina.taskapp.model.Task


@Dao
interface TaskDao {
    @Insert
    fun insert(task: Task)

    @Update
    fun update(task: Task)


    @Delete
    fun delete(task: Task)


    @Query("SELECT * FROM task ORDER BY id DESC")
    fun getAll(): List<Task>
}