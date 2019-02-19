package com.example.hotelbuisinessdb

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.hotelbuisinessdb.dao.*
import com.example.hotelbuisinessdb.entity.*

@Database(
    entities = [Hotel::class, Department::class, Position::class, com.example.hotelbuisinessdb.entity.Room::class, Category::class, Payment::class, Client::class],
    version = 1
)
abstract class MyDataBase : RoomDatabase() {

    abstract fun hotelDao(): HotelDao
    abstract fun categoryDao(): CategoryDao
    abstract fun clientDao(): ClientDao
    abstract fun departmentDao(): DepartmentDao

    /*abstract fun employeeDao(): EmployeeDao*/
    //  abstract fun orderDao(): OrderDao
    abstract fun paymentDao(): PaymentDao

    abstract fun positionDao(): PositionDao
    abstract fun roomDao(): RoomDao

    companion object {
        private var INSTANCE: MyDataBase? = null

        fun getAppDataBase(context: Context): MyDataBase? {
            if (INSTANCE == null) {
                synchronized(MyDataBase::class.java) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, MyDataBase::class.java, "hotels.db")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}