package com.example.hotelbuisinessdb.hotel

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import com.example.hotelbuisinessdb.MyDataBase
import com.example.hotelbuisinessdb.R
import com.example.hotelbuisinessdb.entity.Hotel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_hotels.*

class HotelsActivity : AppCompatActivity() {
    private var db: MyDataBase? = null
    private val adapter = HotelsAdapter()
    private var newList = listOf<Hotel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotels)
        hotelsRec.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        hotelsRec.adapter = adapter

        addBtn.setOnClickListener {
            val intentToHotelsDetails = Intent(this, HotelDetailsActivity::class.java)
            startActivity(intentToHotelsDetails)
        }

        db = MyDataBase.getAppDataBase(this)
        Observable.fromCallable {
            newList = db?.hotelDao()?.all!!
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { adapter.setList(newList) }

        adapter.onClickListener = {
            val dialog = AlertDialog.Builder(this)
                .setTitle(it.address)
                .setMessage("Хотите удалить ${it.address} ?")
                .setPositiveButton("Да") { _, _ ->
                    Observable.fromCallable {
                        db?.hotelDao()?.delete(it)
                        newList = db?.hotelDao()?.all!!
                    }.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe { adapter.setList(newList) }
                }.setNegativeButton("Нет") { dialog, which ->
                    dialog.dismiss()
                }.show()
        }
    }

    override fun onResume() {
        super.onResume()
        Observable.fromCallable {
            newList = db?.hotelDao()?.all!!
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { adapter.setList(newList) }
    }

}
