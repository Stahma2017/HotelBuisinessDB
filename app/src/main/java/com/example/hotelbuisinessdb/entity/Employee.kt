package com.example.hotelbuisinessdb.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(entity = Position::class, parentColumns = ["id"], childColumns = ["position_id"])])
data class Employee(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val firstName: String,
    val secondName: String,
    @ColumnInfo(name = "position_id")
    val positionId: Int)
