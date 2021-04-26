package com.example.testapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi

class Snacks : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snacks)
        window.statusBarColor = 0x000000
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
        actionBar?.hide();

        /*
        Protein Shake
        Greek Yogurt & Fruit
        Roasted Chickpeas
        Eggplant Chips
        Fauxtato Chips
        Zucchini Sushi
        Sweet Potato Chips
        Kachori
        Hard Boiled Eggs
        Mung Bean Sprouts
        Fruit Bowl
        Samosa Chaat
        Spicy Poha
         */
    }
}