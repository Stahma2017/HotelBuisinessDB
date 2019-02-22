package com.example.hotelbuisinessdb.client

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hotelbuisinessdb.MyDataBase
import com.example.hotelbuisinessdb.R
import com.example.hotelbuisinessdb.entity.Client
import kotlinx.android.synthetic.main.activity_client_details.*


class ClientDetailsActivity : AppCompatActivity() {
    private var db: MyDataBase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_details)

        okBtn.setOnClickListener {
            db = MyDataBase.getAppDataBase(this)
            db?.clientDao()?.insert(
                Client(
                    name = firstName.text.toString(),
                    secondName = secondName.text.toString(),
                    passportNumber = Integer.parseInt(passport.text.toString()),
                    phone = phone.text.toString()
                )
            )
            Toast.makeText(this, "Клиент добавлен", Toast.LENGTH_SHORT).show()
        }

    }
}
