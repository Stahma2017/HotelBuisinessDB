package com.example.hotelbuisinessdb.hotel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hotelbuisinessdb.MyDataBase
import com.example.hotelbuisinessdb.R
import com.example.hotelbuisinessdb.entity.Hotel
import kotlinx.android.synthetic.main.activity_hotel_details.*

class HotelDetailsActivity : AppCompatActivity() {
    private var db: MyDataBase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_details)

        okBtn.setOnClickListener {
            db = MyDataBase.getAppDataBase(this)
            db?.hotelDao()?.insert(
                hotel = Hotel(
                    address = addressET.text.toString(),
                    phone = Integer.parseInt(phoneET.text.toString())
                )
            )
            Toast.makeText(this, "Отель добавлен", Toast.LENGTH_SHORT).show()
        }
    }
}
