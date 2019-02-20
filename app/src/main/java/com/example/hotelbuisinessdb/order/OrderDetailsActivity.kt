package com.example.hotelbuisinessdb.order

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hotelbuisinessdb.MyDataBase
import com.example.hotelbuisinessdb.R
import com.example.hotelbuisinessdb.entity.Order
import kotlinx.android.synthetic.main.activity_order_details.*

class OrderDetailsActivity : AppCompatActivity() {
    private var db: MyDataBase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)

        okBtn.setOnClickListener {
            db = MyDataBase.getAppDataBase(this)
            db?.orderDao()?.insert(
                Order(
                    daySnap = Integer.parseInt(daysSpan.text.toString()),
                    startDate = startDay.text.toString(),
                    clientId = Integer.parseInt(clientId.text.toString()),
                    roomId = Integer.parseInt(roomId.text.toString()),
                    paymentId = Integer.parseInt(paymentId.text.toString())
                )
            )
            Toast.makeText(this, "Заказ добавлена", Toast.LENGTH_SHORT).show()
        }

    }
}
