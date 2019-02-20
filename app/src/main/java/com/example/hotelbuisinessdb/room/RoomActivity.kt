package com.example.hotelbuisinessdb.room

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.hotelbuisinessdb.MyDataBase
import com.example.hotelbuisinessdb.R
import com.example.hotelbuisinessdb.entity.Room
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_room.*

class RoomActivity : AppCompatActivity() {
    private var db: MyDataBase? = null
    private val adapter = RoomAdapter()
    private var newList = listOf<Room>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        addBtn.setOnClickListener {
            val intentToRoomDetails = Intent(this, RoomDetailsActivity::class.java)
            startActivity(intentToRoomDetails)
        }

        roomRec.layoutManager =  LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        roomRec.adapter = adapter

        db = MyDataBase.getAppDataBase(this)
        Observable.fromCallable{
            newList = db?.roomDao()?.all!!
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { adapter.setList(newList) }

        adapter.onClickListener = {
            Observable.fromCallable {
                db?.roomDao()?.delete(it)
                newList = db?.roomDao()?.all!!
            }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { adapter.setList(newList) }
        }
    }

    override fun onResume() {
        super.onResume()
        Observable.fromCallable {
            newList = db?.roomDao()?.all!!
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { adapter.setList(newList) }
    }
}
