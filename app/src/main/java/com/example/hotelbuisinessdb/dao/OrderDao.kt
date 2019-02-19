package com.example.hotelbuisinessdb.dao


import android.arch.persistence.room.*
import com.example.hotelbuisinessdb.entity.Order


@Dao
interface OrderDao {

    @get:Query("SELECT * FROM [order]")
    val all: List<Order>

    @Query("SELECT * FROM [order] WHERE id = :id")
    fun getById(id: Int): Order

    @Insert
    fun insert(order: Order)

    @Update
    fun update(order: Order)

    @Delete
    fun delete(order: Order)
}
