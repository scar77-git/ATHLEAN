package com.example.testapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
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

        val bshake = findViewById<Button>(R.id.imageButton5)
        val intent = Intent(this, RecipeActivity::class.java)
        bshake.setOnClickListener(){
            val recode = "Eggplant Chips";
            intent.putExtra("reccode",recode)
            startActivity(intent);
        }
        val tsand = findViewById<Button>(R.id.imageButton6)
        tsand.setOnClickListener(){
            val recode = "Fauxtato Chips";
            intent.putExtra("reccode",recode)
            startActivity(intent);
        }
        val ntpb = findViewById<Button>(R.id.imageButton8)
        ntpb.setOnClickListener(){
            val recode = "Fruit Bowl";
            intent.putExtra("reccode",recode)
            startActivity(intent);
        }
        val oatm = findViewById<Button>(R.id.imageButton9)
        oatm.setOnClickListener(){
            val recode = "Protein Shake";
            intent.putExtra("reccode",recode)
            startActivity(intent);
        }
        val mpor = findViewById<Button>(R.id.imageButton10)
        mpor.setOnClickListener(){
            val recode = "Greek Fruit Bowl";
            intent.putExtra("reccode",recode)
            startActivity(intent);
        }
        val pros = findViewById<Button>(R.id.imageButton11)
        pros.setOnClickListener(){
            val recode = "Kachori";
            intent.putExtra("reccode",recode)
            startActivity(intent);
        }
        val qpor = findViewById<Button>(R.id.imageButton12)
        qpor.setOnClickListener(){
            val recode = "Sweet Potato Chips";
            intent.putExtra("reccode",recode)
            startActivity(intent);
        }
        val wpan = findViewById<Button>(R.id.imageButton13)
        mpor.setOnClickListener(){
            val recode = "Zucchini Sushi";
            intent.putExtra("reccode",recode)
            startActivity(intent);
        }

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