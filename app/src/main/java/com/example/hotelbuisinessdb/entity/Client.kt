package com.example.hotelbuisinessdb.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Client(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val secondName: String,
    val passportNumber: Int,
    val phone: String
)
