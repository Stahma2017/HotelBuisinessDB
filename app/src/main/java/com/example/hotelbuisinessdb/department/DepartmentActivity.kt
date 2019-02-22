package com.example.hotelbuisinessdb.department

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import com.example.hotelbuisinessdb.MyDataBase
import com.example.hotelbuisinessdb.R
import com.example.hotelbuisinessdb.entity.Department
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_department.*


class DepartmentActivity : AppCompatActivity() {

    private var db: MyDataBase? = null
    private val adapter = DepartmentAdapter()
    private var newList = listOf<Department>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_department)

        departmentRec.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        departmentRec.adapter = adapter

        addBtn.setOnClickListener {
            val intentToHotelsDetails = Intent(this, DepartmentDetailsActivity::class.java)
            startActivity(intentToHotelsDetails)
        }

        db = MyDataBase.getAppDataBase(this)
        Observable.fromCallable{
            newList = db?.departmentDao()?.all!!
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {adapter.setList(newList)}


        adapter.onClickListener = {
            val dialog = AlertDialog.Builder(this)
                .setTitle(it.name)
                .setMessage("Хотите удалить ${it.name} ?")
                .setPositiveButton("Да") { _, _ ->
                    Observable.fromCallable {
                        db?.departmentDao()?.delete(it)
                        newList = db?.departmentDao()?.all!!
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
            newList = db?.departmentDao()?.all!!
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { adapter.setList(newList) }
    }
}
