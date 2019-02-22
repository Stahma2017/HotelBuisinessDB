package com.example.hotelbuisinessdb.dao

import android.arch.persistence.room.*
import com.example.hotelbuisinessdb.entity.Employee


@Dao
interface EmployeeDao {
    @get:Query("SELECT * FROM employee")
    val all: List<Employee>

    @Query("SELECT * FROM employee WHERE id = :id")
    fun getById(id: Int): Employee

    @Insert
    fun insert(employee: Employee)

    @Update
    fun update(employee: Employee)

    @Delete
    fun delete(employee: Employee)

 /*   @Insert
    fun insertBothEmployees(employee1: Employee, employee2: Employee)*/
}
