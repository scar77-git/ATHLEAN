package com.example.testapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi

class Lunch : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lunch)
        window.statusBarColor = 0x000000
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
        actionBar?.hide();

        /*
        Vension Burger
        Rice with Broccoli
        Sirloin Steak
        Chicken Breast
        Fish Fillets
        Pork Tenderloin Slices
        Meat Sandwich
        Italian Ravioli
        Paneer Pulao
        Vegetable Rice
        Tuna Sandwich
        Butter Chicken Masala
        Butter Naan
        Paneer Paratha
         */
    }
}