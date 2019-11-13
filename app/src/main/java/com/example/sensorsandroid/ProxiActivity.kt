package com.example.sensorsandroid

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_proxi.*

class ProxiActivity : AppCompatActivity(), SensorEventListener {
    private var sensorManager: SensorManager? = null
    private var sensor: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proxi)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager!!.getDefaultSensor(Sensor.TYPE_PROXIMITY)

        returnBtn.setOnClickListener() {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        var proximidade = event!!.values[0]
            if(proximidade >= 5){
                proxiSwitch.setImageResource(R.drawable.doyourjob)
            }else{
                proxiSwitch.setImageResource(R.drawable.fry)
            }
    }
    override fun onResume() {
        super.onResume()
        sensorManager?.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI)
    }
}
