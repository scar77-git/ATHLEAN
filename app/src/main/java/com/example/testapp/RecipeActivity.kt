package com.example.testapp

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text

class RecipeActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)
        window.statusBarColor = 0x000000
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
        actionBar?.hide();

        val rintent = getIntent();
        val recicode = intent.getStringExtra("reccode")
        val texttitle = findViewById<TextView>(R.id.textView3)
        val recidesc = findViewById<TextView>(R.id.desc)
        val recipe = findViewById<TextView>(R.id.recipe)
        val ingredients = findViewById<TextView>(R.id.ingredients)
        lateinit var database: DatabaseReference
        database = Firebase.database.reference
        database.child("Diet").child(recicode.toString()).child("title").get().addOnSuccessListener {
            Log.i("firebase", "Got value ${it.value}")
            texttitle.text = it.value.toString()
        }.addOnFailureListener{
            Log.e("firebase", "Error getting data", it)
        }
        database.child("Diet").child(recicode.toString()).child("desc").get().addOnSuccessListener {
            Log.i("firebase", "Got value ${it.value}")
            recidesc.text = it.value.toString()
        }.addOnFailureListener{
            Log.e("firebase", "Error getting data", it)
        }
        database.child("Diet").child(recicode.toString()).child("ingredients").get().addOnSuccessListener {
            Log.i("firebase", "Got value ${it.value}")
            ingredients.text = it.value.toString()
        }.addOnFailureListener{
            Log.e("firebase", "Error getting data", it)
        }
        database.child("Diet").child(recicode.toString()).child("recipe").get().addOnSuccessListener {
            Log.i("firebase", "Got value ${it.value}")
            recipe.text = it.value.toString()
        }.addOnFailureListener{
            Log.e("firebase", "Error getting data", it)
        }
    }
}