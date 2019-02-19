package com.example.hotelbuisinessdb.dao

import android.arch.persistence.room.*
import com.example.hotelbuisinessdb.entity.Hotel

@Dao
interface HotelDao {
    @get:Query("SELECT * FROM hotel")
    val all: List<Hotel>

    @Query("SELECT * FROM hotel WHERE id = :id")
    fun getById(id: Int): Hotel

    @Insert
    fun insert(hotel: Hotel)

    @Update
    fun update(hotel: Hotel)

    @Delete
    fun delete(hotel: Hotel)
}