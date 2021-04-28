package com.example.testapp
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.workout1.*

class workout : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.workout1)
        window.statusBarColor = 0x000000
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
        actionBar?.hide();
        val button2: Button = findViewById(R.id.chest)
        button2.setOnClickListener {
            val intent = Intent(this, chest1::class.java)
            startActivity(intent)


        }
        val button3: Button = findViewById(R.id.abs)
        button3.setOnClickListener {
            val intent = Intent(this, abs1::class.java)
            startActivity(intent)


        }
        val button4: Button = findViewById(R.id.leg)
        button4.setOnClickListener {
            val intent = Intent(this, leg1::class.java)
            startActivity(intent)


        }
        val button5: Button = findViewById(R.id.shld)
        button5.setOnClickListener {
            val intent = Intent(this, shoulder1::class.java)
            startActivity(intent)


        }
        val button6: Button = findViewById(R.id.ft)
        button6.setOnClickListener {
            val intent = Intent(this,fit::class.java)
            startActivity(intent)


        }
        val button7: Button = findViewById(R.id.ar)
        button7.setOnClickListener {
            val intent = Intent(this, arm::class.java)
            startActivity(intent)


        }
    }
}