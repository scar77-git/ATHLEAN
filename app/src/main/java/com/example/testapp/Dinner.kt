package com.example.testapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi

class Dinner : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dinner)
        window.statusBarColor = 0x000000
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
        actionBar?.hide();

        /*
        Salmon Salad
        Avocado Chicken Salad
        Chicken Roast
        Kung Pao Chicken
        Caesers Salad
        Tofu Scramble
        Chickpea Salad
        Baked Salmon
        Black Bean Soup
        Rajma Masala
        Khichdi
        Aloo Paratha
        Lasagna
        Veg Pulao
         */
    }
}