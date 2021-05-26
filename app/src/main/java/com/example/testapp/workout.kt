package com.example.testapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.system.Os.getuid
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


class workout : AppCompatActivity() {
    var firebaseDatabase: FirebaseDatabase? = null

    // creating a variable for our
    // Database Reference for Firebase.
    var databaseReference: DatabaseReference? = null

    // variable for Text view.
    private var retriveTV: TextView? = null
    @SuppressLint("WrongViewCast")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.workout1)
        window.statusBarColor = 0x000000
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
        actionBar?.hide();
        retriveTV = findViewById(R.id.title);
        firebaseDatabase = FirebaseDatabase.getInstance();

        // below line is used to get
        // reference for our database.
        databaseReference = firebaseDatabase!!.getReference("user");
        val uid :String= FirebaseAuth.getInstance().getCurrentUser().getUid()
       /* databaseReference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                val value = snapshot.child(uid).child("flag").getValue(String::class.java)!!

                // after getting the value we are setting
                // our value to our text view in below line.
                retriveTV?.setText(value)
            }

            override fun onCancelled(error: DatabaseError) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(this@workout, "Fail to get data.", Toast.LENGTH_SHORT).show()
            }
        })*/
        val hbutton = findViewById<ImageView>(R.id.imageView3)
        hbutton.setOnClickListener(){
            val intent  = Intent(this, MainActivity::class.java)
            startActivity(intent);
        finish();
        }
        val button2: Button = findViewById(R.id.chest)
        button2.setOnClickListener {
            val intent = Intent(this, chest1::class.java)
            startActivity(intent)


        }
        val button3: Button = findViewById(R.id.abs)
        button3.setOnClickListener {
            val intent = Intent(this, abs1::class.java)
            startActivity(intent)


        }
        val button4: Button = findViewById(R.id.leg)
        button4.setOnClickListener {
            val intent = Intent(this, leg1::class.java)
            startActivity(intent)


        }
        val button5: Button = findViewById(R.id.shld)
        button5.setOnClickListener {
            val intent = Intent(this, shoulder1::class.java)
            startActivity(intent)


        }
        val button6: Button = findViewById(R.id.ft)
        button6.setOnClickListener {
            val intent = Intent(this,fit::class.java)
            startActivity(intent)


        }
        val button7: Button = findViewById(R.id.ar)
        button7.setOnClickListener {
            val intent = Intent(this, arm::class.java)
            startActivity(intent)


        }
    }
}