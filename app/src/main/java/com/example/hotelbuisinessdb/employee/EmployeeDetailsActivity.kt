package com.example.hotelbuisinessdb.employee

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hotelbuisinessdb.MyDataBase
import com.example.hotelbuisinessdb.R
import com.example.hotelbuisinessdb.entity.Employee
import kotlinx.android.synthetic.main.activity_employee_details.*

class EmployeeDetailsActivity : AppCompatActivity() {
    private var db: MyDataBase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_details)

        okBtn.setOnClickListener {
            db = MyDataBase.getAppDataBase(this)
            db?.employeeDao()?.insert(
                Employee(firstName = firstName.text.toString(),
                    secondName = secondName.text.toString(),
                    positionId = Integer.parseInt(positionId.text.toString()))
            )
            Toast.makeText(this, "Работник добавлен", Toast.LENGTH_SHORT).show()
        }

    }
}
