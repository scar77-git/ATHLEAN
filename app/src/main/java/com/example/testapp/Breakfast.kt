package com.example.testapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi

class Breakfast : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breakfast)
        window.statusBarColor = 0x000000
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
        actionBar?.hide();

        /*Mighty Porridge aka chia porridge
        Nuts&Fruit PowerBowl
        WholeGrain Pancakes
        Quinoa Porridge
        Banana Shake
        Turkey Sandwich
        Oatmeal
        Protein Shake
        Banana Pancakes
        Chicken Omelette
        Greek Yogurt Super Bowl
        Avocado Eggs
        Protein Pancakes
        Fermented Rice
        Overnight Oats
         */
    }
}