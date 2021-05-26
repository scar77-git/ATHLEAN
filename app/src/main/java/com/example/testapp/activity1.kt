package com.example.testapp
import android.R.attr.button
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.squareup.picasso.Picasso


class activity1 : AppCompatActivity() {
    // Initializing the ImageView
    var rImage: ImageView? = null
    var data: String? = null
    var data1:String?=null
    var data2:String?=null
    var getImage:DatabaseReference?=null
    private var sets1: EditText? = null
    private var time1: EditText? = null
    private var review1: EditText? = null
    var info: user? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sample1)
        data = intent.getStringExtra("val_1")
            // getting ImageView by its id
            rImage = findViewById(R.id.rImage)

        val button2: Button = findViewById(R.id.go)
        button2.setOnClickListener {
            if(data=="pushups")
            {
            data2="pushups"}
            else if(data=="decpushups")
            {
                data2= "decpushups"}
            else if (data=="fdcp"){
                data2= "fdcp"}
            else if (data=="planks"){
                data2="planks"}
            else if (data=="crunches"){
                data2="crunches"}
            else if (data=="legraises"){
                data2="legraises"}
            val intent = Intent(this, video1::class.java)
            intent.putExtra("val_1", data2)
            startActivity(intent)
        }
        val button3: Button = findViewById(R.id.home)
        button3.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val button4: Button = findViewById(R.id.start)
        button4.setOnClickListener {
            val intent = Intent(this, pulse1::class.java)
            startActivity(intent)
        }
       /* val button5:Button=findViewById(R.id.btl)
        Toast.makeText(parent, "liked", Toast.LENGTH_SHORT).show() })
        val button6:Button=findViewById(R.id.btd)
        button6.setOnClickListener(View.OnClickListener { button6.setBackgroundColor(resources.getColor(R.color.crimson)) })*/


            // we will get the default FirebaseDatabase instance
            val firebaseDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()


            // we will get a DatabaseReference for the database root node
            var databaseReference: DatabaseReference = firebaseDatabase.reference


            // Here "image" is the child node value we are getting

            // child node data in the getImage variable
        //val getImage: DatabaseReference = databaseReference.child("images").child("decpushups")
            if(data=="pushups")
            {
            getImage= databaseReference.child("images").child("pushups")
                rImage?.setBackgroundResource(R.drawable.pushups);}
         else if(data=="decpushups")
        {
            getImage= databaseReference.child("images").child("decpushups")
            rImage?.setBackgroundResource(R.drawable.decpushup);}
         else if (data=="fdcp"){
                getImage= databaseReference.child("images").child("fdcp")
                rImage?.setBackgroundResource(R.drawable.fdcp);}
            else if (data=="planks"){
                getImage= databaseReference.child("images").child("planks")
                rImage?.setBackgroundResource(R.drawable.plank);}
            else if (data=="crunches"){
                getImage= databaseReference.child("images").child("crunches")
                rImage?.setBackgroundResource(R.drawable.crunches);}
            else if (data=="legraises"){
                getImage= databaseReference.child("images").child("legraises")
                rImage?.setBackgroundResource(R.drawable.legraises);}


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
        databaseReference = firebaseDatabase!!.getReference("userinfo")
        info= user()
        var sendDatabtn:Button = findViewById(R.id.btn)
        sets1 = findViewById(R.id.ht)
        time1 = findViewById(R.id.ht1)
        review1 = findViewById(R.id.ht2)
        sendDatabtn?.setOnClickListener(View.OnClickListener {
            // getting text from our edittext fields.
            val st = Integer.parseInt(sets1?.getText().toString())
            val t = Integer.parseInt(time1?.getText().toString())
            val r = review1?.getText().toString()

            // below line is for checking weather the
            // edittext fields are empty or not.
            if (TextUtils.isEmpty(st.toString()) && TextUtils.isEmpty(t.toString()) && TextUtils.isEmpty(r) ){
                // if the text fields are empty
                // then show the below message.
                Toast.makeText(this@activity1, "Please add some data.", Toast.LENGTH_SHORT).show()
            } else {
                info?.setSets(st)
                info?.settime(t)
                info?.setReview(r)

                databaseReference!!.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        // inside the method of on Data change we are setting
                        // our object class to our database reference.
                        // data base reference will sends data to firebase.
                        val uid :String= FirebaseAuth.getInstance().getCurrentUser().getUid()
                        databaseReference!!.child(uid).setValue(info)

                        // after adding this data we are showing toast message.
                        Toast.makeText(this@activity1, "data added", Toast.LENGTH_SHORT).show()
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // if the data is not added or it is cancelled then
                        // we are displaying a failure toast message.
                        Toast.makeText(this@activity1, "Fail to add data $error", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        })
        }
    }

