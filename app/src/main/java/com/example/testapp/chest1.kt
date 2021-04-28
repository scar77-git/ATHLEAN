package com.example.testapp

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class chest1 :AppCompatActivity() {
    val val1:String?="pushups"
    val val2:String?="decpushups"
    val val3:String?="fdcp"
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.chest)
            window.statusBarColor = 0x000000
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
            supportActionBar?.hide()
            actionBar?.hide();
            val button2: Button = findViewById(R.id.stdph)
            button2.setOnClickListener {
                val intent = Intent(this, activity1::class.java)
                intent.putExtra("val_1", val1)
                startActivity(intent)


            }
            val button3: Button = findViewById(R.id.decph)
            button3.setOnClickListener {
                val intent = Intent(this, activity1::class.java)
                intent.putExtra("val_1", val2)
                startActivity(intent)


            }
            val button4: Button = findViewById(R.id.fdc)
            button4.setOnClickListener {
                val intent = Intent(this, activity1::class.java)
                intent.putExtra("val_1", val3)
                startActivity(intent)


            }

        }
    }
