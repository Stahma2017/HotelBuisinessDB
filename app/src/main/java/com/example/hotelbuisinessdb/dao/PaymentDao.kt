package com.example.hotelbuisinessdb.dao

import android.arch.persistence.room.*
import com.example.hotelbuisinessdb.entity.Payment


@Dao
interface PaymentDao {
    @get:Query("SELECT * FROM payment")
    val all: List<Payment>

    @Query("SELECT * FROM payment WHERE id = :id")
    fun getById(id: Int): Payment

    @Insert
    fun insert(payment: Payment)

    @Update
    fun update(payment: Payment)

    @Delete
    fun delete(payment: Payment)
}
