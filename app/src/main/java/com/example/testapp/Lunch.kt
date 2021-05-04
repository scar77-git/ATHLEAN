package com.example.testapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
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

        val bshake = findViewById<Button>(R.id.imageButton5)
        val intent = Intent(this, RecipeActivity::class.java)
        bshake.setOnClickListener(){
            val recode = "Chicken Breast Pan";
            intent.putExtra("reccode",recode)
            startActivity(intent);
        }
        val tsand = findViewById<Button>(R.id.imageButton6)
        tsand.setOnClickListener(){
            val recode = "Tuna Sandwich";
            intent.putExtra("reccode",recode)
            startActivity(intent);
        }
        val ntpb = findViewById<Button>(R.id.imageButton8)
        ntpb.setOnClickListener(){
            val recode = "Butter Chicken Masala";
            intent.putExtra("reccode",recode)
            startActivity(intent);
        }
        val oatm = findViewById<Button>(R.id.imageButton9)
        oatm.setOnClickListener(){
            val recode = "Paneer Pulao";
            intent.putExtra("reccode",recode)
            startActivity(intent);
        }
        val mpor = findViewById<Button>(R.id.imageButton10)
        mpor.setOnClickListener(){
            val recode = "Beef Ravioli";
            intent.putExtra("reccode",recode)
            startActivity(intent);
        }
        val pros = findViewById<Button>(R.id.imageButton11)
        pros.setOnClickListener(){
            val recode = "Sirloin Steak";
            intent.putExtra("reccode",recode)
            startActivity(intent);
        }
        val qpor = findViewById<Button>(R.id.imageButton12)
        qpor.setOnClickListener(){
            val recode = "Vension Burger";
            intent.putExtra("reccode",recode)
            startActivity(intent);
        }
        val wpan = findViewById<Button>(R.id.imageButton13)
        mpor.setOnClickListener(){
            val recode = "fish fillets";
            intent.putExtra("reccode",recode)
            startActivity(intent);
        }

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