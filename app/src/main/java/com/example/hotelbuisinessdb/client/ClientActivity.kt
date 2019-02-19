package com.example.hotelbuisinessdb.client

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.hotelbuisinessdb.MyDataBase
import com.example.hotelbuisinessdb.R
import com.example.hotelbuisinessdb.entity.Client
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_client.*


class ClientActivity : AppCompatActivity() {

    private var db: MyDataBase? = null
    private val adapter = ClientAdapter()
    private var newList = listOf<Client>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client)

        clientRec.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        clientRec.adapter = adapter

        db = MyDataBase.getAppDataBase(this)
        Observable.fromCallable {
            newList = db?.clientDao()?.all!!
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { adapter.setList(newList) }
    }
}
