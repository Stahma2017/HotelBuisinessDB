package com.example.hotelbuisinessdb.employee

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.hotelbuisinessdb.MyDataBase
import com.example.hotelbuisinessdb.R
import com.example.hotelbuisinessdb.entity.Employee
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_employee.*

class EmployeeActivity : AppCompatActivity() {
    private var db: MyDataBase? = null
    private val adapter = EmployeeAdapter()
    private var newList = listOf<Employee>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee)
        employeesRec.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        employeesRec.adapter = adapter

        addBtn.setOnClickListener {
            val intentToHotelsDetails = Intent(this, EmployeeDetailsActivity::class.java)
            startActivity(intentToHotelsDetails)
        }

        db = MyDataBase.getAppDataBase(this)
        Observable.fromCallable {
            newList = db?.employeeDao()?.all!!
            newList?.let { adapter.setList(it) }
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()

        adapter.onClickListener = {
            Observable.fromCallable {
                db?.employeeDao()?.delete(it)
                newList = db?.employeeDao()?.all!!
            }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { adapter.setList(newList) }
        }
    }

    override fun onResume() {
        super.onResume()
        Observable.fromCallable {
            newList = db?.employeeDao()?.all!!
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { adapter.setList(newList) }
    }
}
