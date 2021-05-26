package com.example.testapp

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


class MainActivity : AppCompatActivity() {
    var firebaseDatabase: FirebaseDatabase? = null
    // creating a variable for our Database
    // Reference for Firebase.
    var databaseReference: DatabaseReference? = null
    // creating a variable for
    // our object class
    var employeeInfo: user? = null
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor = 0x000000
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
        actionBar?.hide();
        firebaseDatabase = FirebaseDatabase.getInstance()

        // below line is used to get reference for our database.
        databaseReference = firebaseDatabase!!.getReference("user1")



        // initializing our object
        // class variable.
        val uid :String= FirebaseAuth.getInstance().getCurrentUser().getUid()


        val button10 = findViewById<ImageButton>(R.id.imageButton3)
        button10.setOnClickListener {
            val intent = Intent(this, diet::class.java)
            startActivity(intent)
        }
        val button2 = findViewById<ImageButton>(R.id.imageButton7)
        button2.setOnClickListener {
            /*databaseReference!!.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    // this method is call to get the realtime
                    // updates in the data.
                    // this method is called when the data is
                    // changed in our Firebase console.
                    // below line is for getting the data from
                    // snapshot of our database.
                    val value = snapshot.child(uid).child("flag").getValue(String::class.java)!!

                    getdata(value)
                    // after getting the value we are setting
                    // our value to our text view in below line.
                }
                override fun onCancelled(error: DatabaseError) {
                    // calling on cancelled method when we receive
                    // any error or we are not able to get the data.
                    Toast.makeText(this@MainActivity, "Fail to get data.", Toast.LENGTH_SHORT).show()
                }
            })*/
            val intent=Intent(this,wk::class.java)
            startActivity(intent)

        }
        val button7: ImageButton = findViewById(R.id.imageButton4)
        button7.setOnClickListener {

            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, login1::class.java)
            startActivity(intent)
            finish()
        }

    }
   /* private fun getdata(f:String){
        if(f=="true")
        {
            val intent=Intent(this,workout::class.java)
            startActivity(intent)
        }
        else{
            val intent=Intent(this,wk::class.java)
            startActivity(intent)
        }

    }*/

}

