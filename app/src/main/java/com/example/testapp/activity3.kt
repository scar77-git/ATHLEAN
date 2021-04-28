package com.example.testapp
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso;

class activity3 : AppCompatActivity() {
    // Initializing the ImageView
    var rImage: ImageView? = null
    var data: String? = null
    var data1:String?=null
    var getImage:DatabaseReference?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sample1)
        data = intent.getStringExtra("val_1")
        // getting ImageView by its id
        rImage = findViewById(R.id.rImage)


        // we will get the default FirebaseDatabase instance
        val firebaseDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()


        // we will get a DatabaseReference for the database root node
        val databaseReference: DatabaseReference = firebaseDatabase.reference


        // Here "image" is the child node value we are getting

        // child node data in the getImage variable
        //val getImage: DatabaseReference = databaseReference.child("images").child("decpushups")
        if(data=="ac")
        {
            getImage= databaseReference.child("images").child("ac")}
        else if(data=="td")
        {
            getImage= databaseReference.child("images").child("td")}
        else if (data=="sp"){
            getImage= databaseReference.child("images").child("sp")}
        else if (data=="sk"){
            getImage= databaseReference.child("images").child("sk")}
        else if (data=="hk"){
            getImage= databaseReference.child("images").child("hk")}
        else if (data=="jj"){
            getImage= databaseReference.child("images").child("jj")}


        // Adding listener for a single change

        // in the data at this location.

        // this listener will triggered once

        // with the value of the data at the location
        getImage?.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                // getting a DataSnapshot for the location at the specified

                // relative path and getting in the link variable
                val link: String? = dataSnapshot.getValue(String::class.java)


                // loading that data into rImage

                // variable which is ImageView
                Picasso.get().load(link).into(rImage)
            }

            // this will called when any problem
            // occurs in getting data
            override fun onCancelled(databaseError: DatabaseError) {

                // we are showing that error message in toast
                Toast.makeText(this@activity3, "Error Loading Image", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

