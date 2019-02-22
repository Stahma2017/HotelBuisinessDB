package com.example.hotelbuisinessdb

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.hotelbuisinessdb.login.Account
import kotlinx.android.synthetic.main.activity_main.*

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        okBtn.setOnClickListener {validateUserData()}
    }

    private fun validateUserData(){
        if (passwordET.text.toString() != "" && loginET.text.toString() != ""){
           if(loginET.text.toString() == Account.ADMIN_LOGIN && passwordET.text.toString() == Account.ADMIN_PASSWORD){
               val intentToMenu = Intent(this, MenuActivity::class.java)
               startActivity(intentToMenu)
           }
        }
    }
}
