package com.example.testapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.annotation.RequiresApi
import com.google.firebase.storage.StorageReference as GoogleFirebaseStorageStorageReference

class MealActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal)
        window.statusBarColor = 0x000000
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
        actionBar?.hide();

        val button1 = findViewById<Button>(R.id.button)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        button1.setOnClickListener {
            val intent = Intent(this, Breakfast::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener {
            val intent = Intent(this, Lunch::class.java)
            startActivity(intent)
        }
        button3.setOnClickListener {
            val intent = Intent(this, Dinner::class.java)
            startActivity(intent)
        }
        button4.setOnClickListener {
            val intent = Intent(this, Snacks::class.java)
            startActivity(intent)
        }

    }
}