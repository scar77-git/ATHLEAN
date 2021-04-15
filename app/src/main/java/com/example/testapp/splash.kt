package com.example.testapp

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class splash : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash1)

        // This is used to hide the status bar and make
        // the splash screen as a full screen activity.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.splash1)
        window.statusBarColor = 0x1A1A1A
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
        actionBar?.hide();
        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        val pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE)
        if (pref.getBoolean("activity_executed", true)) {
            Handler().postDelayed({val intent = Intent(this, login1::class.java)
                startActivity(intent)
                finish()},3000)
        } else {
            Handler().postDelayed({val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()},3000)
        }
    }
}