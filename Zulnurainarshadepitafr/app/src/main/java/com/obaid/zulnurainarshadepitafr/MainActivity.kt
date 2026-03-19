package com.obaid.zulnurainarshadepitafr

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val clockactivity = findViewById<Button>(R.id.button1)
        val alaramactivity = findViewById<Button>(R.id.button2)
        val timeTextView = findViewById<TextView>(R.id.timeTextView)
        val timerstopwatch = findViewById<Button>(R.id.button3)


        val currentTime = Calendar.getInstance().time
        val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        val timeString = sdf.format(currentTime)

        timeTextView.text = timeString

        clockactivity.setOnClickListener {
            val intent = Intent(this, ClockActivity::class.java)
            startActivity(intent)
        }
        alaramactivity.setOnClickListener {
            val intent = Intent(this, AlaramActivity::class.java)
            startActivity(intent)
        }
        timerstopwatch.setOnClickListener {
            val intent  = Intent(this, TimerStopwatch::class.java)
            startActivity(intent)
        }

    }
}