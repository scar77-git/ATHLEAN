package com.example.testapp
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class wk :AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.type)
        window.statusBarColor = 0x000000
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
        actionBar?.hide();
        var firebaseDatabase = FirebaseDatabase.getInstance()

        // below line is used to get reference for our database.
        var databaseReference = firebaseDatabase!!.getReference("user")

         var info1=user()
        val button2: Button = findViewById(R.id.ss)
        button2.setOnClickListener {
            info1?.setst(2)
            info1?.settimes(15)
            info1?.setflag("true")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

                override fun onDataChange(snapshot: DataSnapshot) {
                    // inside the method of on Data change we are setting
                    // our object class to our database reference.
                    // data base reference will sends data to firebase.
                    val uid :String= FirebaseAuth.getInstance().getCurrentUser().getUid()
                    databaseReference!!.child(uid).setValue(info1)

                    // after adding this data we are showing toast message.
                    Toast.makeText(this@wk, "Slow-start", Toast.LENGTH_SHORT).show()
                }


            })
            val intent = Intent(this, weeks1::class.java)
            startActivity(intent)


        }
        val button3: Button = findViewById(R.id.expe)
        button3.setOnClickListener {
            info1?.setst(3)
            info1?.settimes(20)
            info1?.setflag("true")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

                override fun onDataChange(snapshot: DataSnapshot) {
                    // inside the method of on Data change we are setting
                    // our object class to our database reference.
                    // data base reference will sends data to firebase.
                    val uid :String= FirebaseAuth.getInstance().getCurrentUser().getUid()
                    databaseReference!!.child(uid).setValue(info1)

                    // after adding this data we are showing toast message.
                    Toast.makeText(this@wk, "Experienced", Toast.LENGTH_SHORT).show()
                }


            })
            val intent = Intent(this, weeks1::class.java)
            startActivity(intent)


        }
        val button4: Button = findViewById(R.id.exp)
        button4.setOnClickListener {
            info1?.setst(4)
            info1?.settimes(25)
            info1?.setflag("true")
            databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

                override fun onDataChange(snapshot: DataSnapshot) {
                    // inside the method of on Data change we are setting
                    // our object class to our database reference.
                    // data base reference will sends data to firebase.
                    val uid :String= FirebaseAuth.getInstance().getCurrentUser().getUid()
                    databaseReference!!.child(uid).setValue(info1)

                    // after adding this data we are showing toast message.
                    Toast.makeText(this@wk, "Expert", Toast.LENGTH_SHORT).show()
                }


            })
            val intent = Intent(this, weeks1::class.java)
            startActivity(intent)


        }

    }
}