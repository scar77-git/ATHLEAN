package com.example.testapp
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class leg1 :AppCompatActivity() {
    val val1:String?="sq"
    val val2:String?="lun"
    val val3:String?="slcr"
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.leg)
        window.statusBarColor = 0x000000
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
        actionBar?.hide();
        val button2: Button = findViewById(R.id.sq)
        button2.setOnClickListener {
            val intent = Intent(this, activity2::class.java)
            intent.putExtra("val_1", val1)
            startActivity(intent)


        }
        val button3: Button = findViewById(R.id.lun)
        button3.setOnClickListener {
            val intent = Intent(this, activity2::class.java)
            intent.putExtra("val_1", val2)
            startActivity(intent)


        }
        val button4: Button = findViewById(R.id.slcr)
        button4.setOnClickListener {
            val intent = Intent(this, activity2::class.java)
            intent.putExtra("val_1", val3)
            startActivity(intent)


        }

    }
}