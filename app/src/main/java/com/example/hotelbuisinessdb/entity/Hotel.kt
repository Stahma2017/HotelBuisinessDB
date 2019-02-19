package com.example.hotelbuisinessdb.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Hotel(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val address: String,
    val phone: Int)