package com.example.hotelbuisinessdb.payment

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import com.example.hotelbuisinessdb.MyDataBase
import com.example.hotelbuisinessdb.R
import com.example.hotelbuisinessdb.entity.Payment
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_payment.*

class PaymentActivity : AppCompatActivity() {
    private var db: MyDataBase? = null
    private val adapter = PaymentAdapter()
    private var newList = listOf<Payment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)


        paymentRec.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        paymentRec.adapter = adapter

        addBtn.setOnClickListener {
            val intentToHotelsDetails = Intent(this, PaymentDetailsActivity::class.java)
            startActivity(intentToHotelsDetails)
        }

        db = MyDataBase.getAppDataBase(this)
        Observable.fromCallable {
            newList = db?.paymentDao()?.all!!
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { adapter.setList(newList) }

        adapter.onClickListener = {
            val dialog = AlertDialog.Builder(this)
                .setTitle("$it.id")
                .setMessage("Хотите удалить ${it.id} ?")
                .setPositiveButton("Да") { _, _ ->
                    Observable.fromCallable {
                        db?.paymentDao()?.delete(it)
                        newList = db?.paymentDao()?.all!!
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
            newList = db?.paymentDao()?.all!!
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { adapter.setList(newList) }
    }
}
