package com.example.hotelbuisinessdb.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(entity = Category::class, parentColumns = ["id"], childColumns = ["category_id"])])
data class Room(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val doorNumber: Int,
    val description: String,
    @ColumnInfo(name = "category_id")
    val categoryId: Int)
