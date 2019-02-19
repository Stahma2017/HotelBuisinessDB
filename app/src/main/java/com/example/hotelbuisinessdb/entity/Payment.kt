package com.example.hotelbuisinessdb.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
@Entity
data class Payment(@PrimaryKey(autoGenerate = true)
                   val id: Int? = null,
                   val creditNumber: Int,
                   val cost: Int)
