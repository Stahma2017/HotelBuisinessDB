package com.example.hotelbuisinessdb.employee

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.hotelbuisinessdb.MyDataBase
import com.example.hotelbuisinessdb.R
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_employee.*

class EmployeeActivity : AppCompatActivity() {
    private var db: MyDataBase? = null
    private val adapter = EmployeeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee)
        employeesRec.layoutManager =   LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        employeesRec.adapter = adapter

       /* db = MyDataBase.getAppDataBase(this)
        Observable.fromCallable{
            val list = db?.employeeDao()?.all
            list?.let { adapter.setList(it) }
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()*/

    }
}
