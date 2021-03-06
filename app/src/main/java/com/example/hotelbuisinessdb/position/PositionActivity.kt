package com.example.hotelbuisinessdb.position

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.hotelbuisinessdb.MyDataBase
import com.example.hotelbuisinessdb.R
import com.example.hotelbuisinessdb.entity.Position
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_position.*

class PositionActivity : AppCompatActivity() {
    private var db: MyDataBase? = null
    private val adapter = PositionAdapter()
    private var newList = listOf<Position>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_position)

        positionRec.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        positionRec.adapter = adapter

        db = MyDataBase.getAppDataBase(this)
        Observable.fromCallable{
            newList = db?.positionDao()?.all!!
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { adapter.setList(newList) }
    }
}
