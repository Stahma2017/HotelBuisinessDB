package com.example.hotelbuisinessdb.payment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hotelbuisinessdb.MyDataBase
import com.example.hotelbuisinessdb.R
import com.example.hotelbuisinessdb.entity.Payment
import kotlinx.android.synthetic.main.activity_payment_details.*

class PaymentDetailsActivity : AppCompatActivity() {
    private var db: MyDataBase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_details)
        okBtn.setOnClickListener {
            db = MyDataBase.getAppDataBase(this)
            db?.paymentDao()?.insert(
                Payment(
                   creditType = card.text.toString(),
                    cost = Integer.parseInt(cost.text.toString())
                )
            )
            Toast.makeText(this, "Оплата добавлена", Toast.LENGTH_SHORT).show()
        }
    }
}
