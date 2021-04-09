package com.example.testapp
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.diet
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val button: Button = findViewById(R.id.fitness)
        button.setOnClickListener {
            val intent = Intent(this, workout::class.java)
            startActivity(intent)
        }
        val button2: Button = findViewById(R.id.dietbutton)
        button2.setOnClickListener {
            val intent = Intent(this, diet::class.java)
            startActivity(intent)
        }

    }
}
