package com.example.sensorsandroid

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_giro.*

class GyroActivity : AppCompatActivity(), SensorEventListener {

    private var sensorManager: SensorManager? = null
    private var sensor: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_giro)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager?.getDefaultSensor(Sensor.TYPE_GYROSCOPE)

        returnBtn.setOnClickListener(){
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }

    override fun onSensorChanged(p0: SensorEvent) {
        var x = p0.values[0]
        var y = p0.values[1]
        var z = p0.values[2]

        giroX.text = x.toString()
        giroY.text = y.toString()
        giroZ.text = z.toString()
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int){

    }

    override fun onResume() {
        super.onResume()
        sensorManager?.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI)
    }

    override fun onPause() {
        super.onPause()
        sensorManager?.unregisterListener(this)
    }


}
