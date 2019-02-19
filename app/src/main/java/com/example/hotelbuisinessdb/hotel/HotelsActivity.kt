package com.example.hotelbuisinessdb.hotel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.hotelbuisinessdb.MyDataBase
import com.example.hotelbuisinessdb.R
import com.example.hotelbuisinessdb.entity.Hotel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_hotels.*

class HotelsActivity : AppCompatActivity() {
    private var db: MyDataBase? = null
    private val adapter = HotelsAdapter()
    private var newList = listOf<Hotel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotels)
        hotelsRec.layoutManager =   LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        hotelsRec.adapter = adapter

        db = MyDataBase.getAppDataBase(this)
        Observable.fromCallable{
            newList = db?.hotelDao()?.all!!
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { adapter.setList(newList) }


    }
}
