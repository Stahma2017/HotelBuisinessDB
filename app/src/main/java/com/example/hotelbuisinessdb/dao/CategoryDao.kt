package com.example.hotelbuisinessdb.dao

import android.arch.persistence.room.*
import com.example.hotelbuisinessdb.entity.Category


@Dao
interface CategoryDao {

    @get:Query("SELECT * FROM category")
    val all: List<Category>

    @Query("SELECT * FROM category WHERE id = :id")
    fun getById(id: Int): Category

    @Insert
    fun insert(category: Category)

    @Update
    fun update(category: Category)

    @Delete
    fun delete(category: Category)

}
