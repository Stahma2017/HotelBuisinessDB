package com.example.hotelbuisinessdb


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.hotelbuisinessdb.client.ClientActivity
import com.example.hotelbuisinessdb.department.DepartmentActivity
import com.example.hotelbuisinessdb.employee.EmployeeActivity
import com.example.hotelbuisinessdb.entity.Category
import com.example.hotelbuisinessdb.entity.Hotel
import com.example.hotelbuisinessdb.entity.Position
import com.example.hotelbuisinessdb.entity.Room
import com.example.hotelbuisinessdb.hotel.HotelsActivity
import com.example.hotelbuisinessdb.order.OrderActivity
import com.example.hotelbuisinessdb.payment.PaymentActivity
import com.example.hotelbuisinessdb.room.RoomActivity
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.activity_menu.*


class MenuActivity : AppCompatActivity() {
    private var db: MyDataBase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        hostelsBtn.setOnClickListener {
            val intentToHotels = Intent(this, HotelsActivity::class.java)
            startActivity(intentToHotels)
        }

        employeesBtn.setOnClickListener {
            val intentToEmployees = Intent(this, EmployeeActivity::class.java)
            startActivity(intentToEmployees)
        }

        roomBtn.setOnClickListener {
            val intentToRooms = Intent(this, RoomActivity::class.java)
            startActivity(intentToRooms)
        }

        clientsBtn.setOnClickListener {
            val intentToClients = Intent(this, ClientActivity::class.java)
            startActivity(intentToClients)
        }

        ordersBtn.setOnClickListener {
            val intentToOrders = Intent(this, OrderActivity::class.java)
            startActivity(intentToOrders)
        }

        paymentBtn.setOnClickListener {
            val intentToPayments = Intent(this, PaymentActivity::class.java)
            startActivity(intentToPayments)
        }

        departmentsBtn.setOnClickListener {
            val intentToDepartment = Intent(this, DepartmentActivity::class.java)
            startActivity(intentToDepartment)
        }

        logoutBtn.setOnClickListener { finish() }


        /*db = MyDataBase.getAppDataBase(this)
        Observable.fromCallable{
            db?.positionDao()?.insert(Position(name = "Мэнэджер", departmentId = 1))
            db?.positionDao()?.insert(Position(name = "Курьер", departmentId = 2))
            db?.positionDao()?.insert(Position(name = "Горничная", departmentId = 3))
            db?.positionDao()?.insert(Position(name = "Старший Мэнэджер", departmentId = 4))
            db?.positionDao()?.insert(Position(name = "Бугалтер", departmentId = 5))
            db?.positionDao()?.insert(Position(name = "Старшая Горниная", departmentId = 6))
            db?.positionDao()?.insert(Position(name = "Администратор", departmentId = 7))
            db?.positionDao()?.insert(Position(name = "Сис. админ", departmentId = 8))
            db?.positionDao()?.insert(Position(name = "Швейцар", departmentId = 9))


        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
*/



         /*db = MyDataBase.getAppDataBase(this)
          Observable.fromCallable{
              db?.categoryDao()?.insert(Category(name = "люкс", personAmount = 2, cost = 2000))
              db?.categoryDao()?.insert(Category(name = "полулюкс", personAmount = 1, cost = 800))
              db?.categoryDao()?.insert(Category(name = "вип", personAmount = 4, cost = 5000))
              db?.categoryDao()?.insert(Category(name = "эконом", personAmount = 1, cost = 600))

          }
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe()*/

/*

        db = MyDataBase.getAppDataBase(this)
        Observable.fromCallable{db?.categoryDao()?.insert(Category(name = "Люкс", personAmount = 2, cost = 1000))}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
*/

        /*

        Observable.fromCallable{
            val list = db?.hotelDao()?.all
            println(list)
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()*/


        /* Observable.just(AppDatabase.getAppDataBase(this)?.hotelDao()?.insert(Hotel(address = "balbal", phone =  333333)))
             .subscribeOn(Schedulers.io())
             .observeOn(Schedulers.io())
             .subscribe()*/


        /*Observable.fromCallable {
            val dao = AppDatabase.getAppDataBase(this)?.hotelDao()
            dao?.insert(Hotel(0, address = "blabla", phone = 333333))
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()*/

    }


}
