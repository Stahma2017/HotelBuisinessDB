package com.example.hotelbuisinessdb.room

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hotelbuisinessdb.MyDataBase
import com.example.hotelbuisinessdb.R
import com.example.hotelbuisinessdb.entity.Room
import kotlinx.android.synthetic.main.activity_room_details.*

class RoomDetailsActivity : AppCompatActivity() {
    private var db: MyDataBase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_details)

        okBtn.setOnClickListener {
            db = MyDataBase.getAppDataBase(this)
            db?.roomDao()?.insert(
               Room(
                   doorNumber = Integer.parseInt(doorNumber.text.toString()),
                   description = description.text.toString(),
                   categoryId = Integer.parseInt(cateogryId.text.toString())
                )
            )
            Toast.makeText(this, "Комната добавлена", Toast.LENGTH_SHORT).show()
        }

    }
}
