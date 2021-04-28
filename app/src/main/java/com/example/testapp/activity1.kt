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

class activity1 : AppCompatActivity() {
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
            if(data=="hp")
            {
            getImage= databaseReference.child("images").child("hp")}
         else if(data=="dfr")
        {
            getImage= databaseReference.child("images").child("dfr")}
         else if (data=="bod"){
                getImage= databaseReference.child("images").child("bod")}
            else if (data=="planks"){
                getImage= databaseReference.child("images").child("planks")}
            else if (data=="crunches"){
                getImage= databaseReference.child("images").child("crunches")}
            else if (data=="legraises"){
                getImage= databaseReference.child("images").child("legraises")}


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
                Toast.makeText(this@activity1, "Error Loading Image", Toast.LENGTH_SHORT).show()
            }
        })
        }
    }

