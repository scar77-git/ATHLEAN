package com.example.testapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
class diet : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.diet1)
        window.statusBarColor = 0x000000
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
        actionBar?.hide();
        val button1 = findViewById<Button>(R.id.bulking)
        val button2 = findViewById<Button>(R.id.weight_loss)
        val button3 = findViewById<Button>(R.id.athlete)
        val button4 = findViewById<Button>(R.id.bb)
        val intent = Intent(this, MealActivity::class.java)
        button1.setOnClickListener {
            startActivity(intent)
        }
        button2.setOnClickListener {
            startActivity(intent)
        }
        button3.setOnClickListener {
            startActivity(intent)
        }
        button4.setOnClickListener {
            startActivity(intent)
        }

    }
}