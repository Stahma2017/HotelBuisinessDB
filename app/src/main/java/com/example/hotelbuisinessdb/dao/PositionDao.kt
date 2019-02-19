package com.example.hotelbuisinessdb.dao

import android.arch.persistence.room.*
import com.example.hotelbuisinessdb.entity.Position


@Dao
interface PositionDao {
    @get:Query("SELECT * FROM position")
    val all: List<Position>

    @Query("SELECT * FROM position WHERE id = :id")
    fun getById(id: Int): Position

    @Insert
    fun insert(position: Position)

    @Update
    fun update(position: Position)

    @Delete
    fun delete(position: Position)
}
