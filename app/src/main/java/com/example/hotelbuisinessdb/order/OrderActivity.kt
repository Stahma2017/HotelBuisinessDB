package com.example.hotelbuisinessdb.order

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.hotelbuisinessdb.MyDataBase
import com.example.hotelbuisinessdb.R
import com.example.hotelbuisinessdb.entity.Order
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity() {

    private var db: MyDataBase? = null
    private val adapter = OrderAdapter()
    private var newList = listOf<Order>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        orderRec.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        orderRec.adapter = adapter

        addBtn.setOnClickListener{
            val intentToOrderDetails = Intent(this, OrderDetailsActivity::class.java)
            startActivity(intentToOrderDetails)
        }


        db = MyDataBase.getAppDataBase(this)
        Observable.fromCallable {
            newList = db?.orderDao()?.all!!
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{adapter.setList(newList)}

        adapter.onClickListener = {
            Observable.fromCallable {
                db?.orderDao()?.delete(it)
                newList = db?.orderDao()?.all!!
            }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { adapter.setList(newList) }
        }

    }

    override fun onResume() {
        super.onResume()
        Observable.fromCallable {
            newList = db?.orderDao()?.all!!
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { adapter.setList(newList) }
    }
}
