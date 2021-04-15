package com.example.testapp
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor = 0x000000
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
        actionBar?.hide();
        val button = findViewById<ImageButton>(R.id.imageButton3)
        button.setOnClickListener {
            val intent = Intent(this, diet::class.java)
            startActivity(intent)
        }
        val button2 = findViewById<ImageButton>(R.id.imageButton7)
        button2.setOnClickListener {
            val intent = Intent(this, workout::class.java)
            startActivity(intent)
        }
    }
}