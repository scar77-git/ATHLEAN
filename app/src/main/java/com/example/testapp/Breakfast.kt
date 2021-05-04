package com.example.testapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_breakfast.*

class Breakfast : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breakfast)
        window.statusBarColor = 0x000000
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
        actionBar?.hide();

        val bshake = findViewById<Button>(R.id.imageButton5)
        val intent = Intent(this, RecipeActivity::class.java)
        bshake.setOnClickListener(){
            val recode = "Banana Shake";
            intent.putExtra("reccode",recode)
            startActivity(intent);
        }
        val tsand = findViewById<Button>(R.id.imageButton6)
        tsand.setOnClickListener(){
            val recode = "Turkey Sandwich";
            intent.putExtra("reccode",recode)
            startActivity(intent);
        }
        val ntpb = findViewById<Button>(R.id.imageButton8)
        ntpb.setOnClickListener(){
            val recode = "Nuts n' Fruits Power Bowl";
            intent.putExtra("reccode",recode)
            startActivity(intent);
        }
        val oatm = findViewById<Button>(R.id.imageButton9)
        oatm.setOnClickListener(){
            val recode = "Oatmeal";
            intent.putExtra("reccode",recode)
            startActivity(intent);
        }
        val mpor = findViewById<Button>(R.id.imageButton10)
        mpor.setOnClickListener(){
            val recode = "Mighty Porridge";
            intent.putExtra("reccode",recode)
            startActivity(intent);
        }
        val pros = findViewById<Button>(R.id.imageButton11)
        pros.setOnClickListener(){
            val recode = "Protein Shake";
            intent.putExtra("reccode",recode)
            startActivity(intent);
        }
        val qpor = findViewById<Button>(R.id.imageButton12)
        qpor.setOnClickListener(){
            val recode = "Quinoa Porridge";
            intent.putExtra("reccode",recode)
            startActivity(intent);
        }
        val wpan = findViewById<Button>(R.id.imageButton13)
        mpor.setOnClickListener(){
            val recode = "Wholegrain Pancakes";
            intent.putExtra("reccode",recode)
            startActivity(intent);
        }


    }
}