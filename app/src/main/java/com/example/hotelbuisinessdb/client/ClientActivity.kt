package com.example.hotelbuisinessdb.client

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.hotelbuisinessdb.MyDataBase
import com.example.hotelbuisinessdb.R
import com.example.hotelbuisinessdb.employee.EmployeeDetailsActivity
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

        addBtn.setOnClickListener {
            val intentToEmployeeDetails = Intent(this, ClientDetailsActivity::class.java)
            startActivity(intentToEmployeeDetails)
        }

        db = MyDataBase.getAppDataBase(this)
        Observable.fromCallable {
            newList = db?.clientDao()?.all!!
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { adapter.setList(newList) }

        adapter.onClickListener = {
            val dialog = AlertDialog.Builder(this)
                .setTitle(it.name)
                .setMessage("Хотите удалить ${it.name} ?")
                .setPositiveButton("Да") { _, _ ->
                    Observable.fromCallable {
                        db?.clientDao()?.delete(it)
                        newList = db?.clientDao()?.all!!
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
            newList = db?.clientDao()?.all!!
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { adapter.setList(newList) }
    }

}
