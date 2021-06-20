package com.example.counteractivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var count = 0;
    var b: Boolean = true;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun start(v: View?) {
        b = true
        count = 0
        var c = findViewById<View>(R.id.counter) as TextView
        Thread(
            Runnable {
                while (b) {
                    runOnUiThread {
                        c.setText(count.toString())
                    }
                    Thread.sleep(100)
                    count++
                }
            }).start()
    }

    fun stop(v: View?) {
        b = false
    }
}