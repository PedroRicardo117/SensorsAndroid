package com.example.sensorsandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lumiBtn.setOnClickListener{
            val i = Intent(this, LumiActivity::class.java)
            startActivity(i)
        }
        accelBtn.setOnClickListener{
            val i = Intent(this, AccelActivity::class.java)
            startActivity(i)
        }

        gyroBtn.setOnClickListener(){
            val i = Intent(this, GyroActivity::class.java)
            startActivity(i)
        }
        proxiBtn.setOnClickListener(){
            val i = Intent(this, ProxiActivity::class.java)
            startActivity(i)
        }
    }
}
