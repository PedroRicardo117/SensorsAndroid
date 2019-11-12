package com.example.sensorsandroid

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_accel.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class AccelActivity : AppCompatActivity(), SensorEventListener {

    private var sensorManager: SensorManager? = null
    private var sensor: Sensor? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accel)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager?.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION)

        returnBtn.setOnClickListener() {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        var x = event!!.values[0]
        var z = event!!.values[1]
        var y = event!!.values[2]

        posX.setText(x.toString())
        posZ.setText(z.toString())
        posY.setText(y.toString())

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

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
