package com.obaid.zulnurainarshadepitafr

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.test.isEnabled
import androidx.core.os.postDelayed
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.os.Handler
import android.os.Looper

class TimerStopwatch : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_timer_stopwatch)

        val tvTimer = findViewById<TextView>(R.id.tvTimer)
        val btnStart = findViewById<Button>(R.id.btnStart)
        val btnStop = findViewById<Button>(R.id.btnStop)
        val btnReset = findViewById<Button>(R.id.btnReset)

        var seconds = 0
        var isRunning = false
        val handler = Handler(Looper.getMainLooper())

        btnStart.setOnClickListener {
            isRunning = true
            btnStart.isEnabled = false
            btnStop.isEnabled = true
            handler.postDelayed(object : Runnable {
                override fun run() {
                    if (isRunning) {
                        seconds++
                        val min = seconds / 60
                        val sec = seconds % 60
                        tvTimer.text = String.format("%02d:%02d", min, sec)
                        handler.postDelayed(this, 1000)
                    }
                }
            }, 1000)
        }

        btnStop.setOnClickListener {
            isRunning = false
            btnStart.isEnabled = true
            btnStop.isEnabled = false
        }

        btnReset.setOnClickListener {
            isRunning = false
            seconds = 0
            tvTimer.text = "00:00"
            btnStart.isEnabled = true
            btnStop.isEnabled = false
        }

    }
}