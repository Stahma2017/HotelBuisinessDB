package com.example.hotelbuisinessdb.dao

import android.arch.persistence.room.*
import com.example.hotelbuisinessdb.entity.Department


@Dao
interface DepartmentDao {
    @get:Query("SELECT * FROM department")
    val all: List<Department>

    @Query("SELECT * FROM department WHERE id = :id")
    fun getById(id: Int): Department

    @Insert
    fun insert(department: Department)

    @Update
    fun update(department: Department)

    @Delete
    fun delete(department: Department)
}
