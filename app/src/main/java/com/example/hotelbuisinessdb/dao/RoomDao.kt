package com.example.hotelbuisinessdb.dao

import android.arch.persistence.room.*
import com.example.hotelbuisinessdb.entity.Room


@Dao
interface RoomDao {

    @get:Query("SELECT * FROM room")
    val all: List<Room>

    @Query("SELECT * FROM room WHERE id = :id")
    fun getById(id: Int): Room

    @Insert
    fun insert(room: Room)

    @Update
    fun update(room: Room)

    @Delete
    fun delete(room: Room)
}
