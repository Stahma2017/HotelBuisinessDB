package com.example.hotelbuisinessdb.department

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hotelbuisinessdb.MyDataBase
import com.example.hotelbuisinessdb.R
import com.example.hotelbuisinessdb.entity.Department
import kotlinx.android.synthetic.main.activity_department_details.*

class DepartmentDetailsActivity : AppCompatActivity() {
    private var db: MyDataBase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_department_details)

        okBtn.setOnClickListener {
            db = MyDataBase.getAppDataBase(this)
            db?.departmentDao()?.insert(
             Department(
                    name = name.text.toString(),
                 hotelId = Integer.parseInt(hotelId.text.toString())
                )
            )
            Toast.makeText(this, "Отель добавлен", Toast.LENGTH_SHORT).show()
        }

    }
}
