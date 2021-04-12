package com.example.testapp
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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