package com.example.testapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
class info1 : AppCompatActivity() {
    var firebaseDatabase: FirebaseDatabase? = null
    var databaseReference: DatabaseReference? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.info)
        val s = findViewById<TextView>(R.id.setview)
        val t = findViewById<TextView>(R.id.timeview)
        firebaseDatabase = FirebaseDatabase.getInstance()

        // below line is used to get reference for our database.
        databaseReference = firebaseDatabase!!.getReference("user")
        val uid: String = FirebaseAuth.getInstance().getCurrentUser().getUid()
        databaseReference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                val value = snapshot.child(uid).child("st").getValue(Int::class.java)!!
                val value1 = snapshot.child(uid).child("times").getValue(Int::class.java)!!
                s.text = "Number of sets:" + String.format("%d", value)
                t.text = "Time per set:" + String.format("%d", value1)
                // after getting the value we are setting
                // our value to our text view in below line.
            }

            override fun onCancelled(error: DatabaseError) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(this@info1, "Fail to get data.", Toast.LENGTH_SHORT).show()
            }
        })
        val button10 = findViewById<Button>(R.id.next)
        button10.setOnClickListener {
            val intent = Intent(this, timer1::class.java)
            startActivity(intent)
        }
    }
}