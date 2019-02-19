package com.example.hotelbuisinessdb.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = Client::class,
        parentColumns = ["id"], childColumns = ["client_id"]
    ),
        ForeignKey(
            entity = Room::class,
            parentColumns = ["id"], childColumns = ["room_id"]
        ),
        ForeignKey(
            entity = Payment::class,
            parentColumns = ["id"], childColumns = ["payment_id"]
        )
    ]
)
data class Order(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val daySnap: Int,
    val startDate: String,
    @ColumnInfo(name = "client_id")
    val clientId: Int,
    @ColumnInfo(name = "room_id")
    val roomId: Int,
    @ColumnInfo(name = "payment_id")
    val paymentId: Int
)


