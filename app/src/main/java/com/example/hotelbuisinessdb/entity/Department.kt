package com.example.hotelbuisinessdb.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(entity = Hotel::class, parentColumns = ["id"], childColumns = ["hotel_id"])])
data class Department(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    @ColumnInfo(name = "hotel_id")
    val hotelId: Int)

