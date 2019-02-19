package com.example.hotelbuisinessdb.dao

import android.arch.persistence.room.*
import com.example.hotelbuisinessdb.entity.Client


@Dao
interface ClientDao {

    @get:Query("SELECT * FROM Client")
    val all: List<Client>

    @Query("SELECT * FROM client WHERE id = :id")
    fun getById(id: Int): Client

    @Insert
    fun insert(client: Client)

    @Update
    fun update(client: Client)

    @Delete
    fun delete(Client: Client)
}
