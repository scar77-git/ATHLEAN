package com.example.testapp
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
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.sample1.*

class activity2 : AppCompatActivity() {
    // Initializing the ImageView
    var rImage: ImageView? = null
    var data: String? = null
    var data1:String?=null
    var data2:String?=null
    private var sets1: EditText? = null
    private var time1: EditText? = null
    private var review1: EditText? = null
    var info: user? = null
    var getImage:DatabaseReference?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sample1)
        data = intent.getStringExtra("val_1")
        // getting ImageView by its id
        rImage = findViewById(R.id.rImage)
        val button2: Button = findViewById(R.id.go)
        button2.setOnClickListener {
            if(data=="hp")
            {
                data2="hp"}
            else if(data=="dfr")
            {
                data2= "dfr"}
            else if (data=="bod"){
                data2= "bod"}
            else if (data=="sq"){
                data2="sq"}
            else if (data=="lun"){
                data2="lun"}
            else if (data=="slcr"){
                data2="slcr"}
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
        // we will get the default FirebaseDatabase instance
        val firebaseDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()


        // we will get a DatabaseReference for the database root node
        var databaseReference: DatabaseReference = firebaseDatabase.reference


        // Here "image" is the child node value we are getting

        // child node data in the getImage variable
        //val getImage: DatabaseReference = databaseReference.child("images").child("decpushups")
        if(data=="hp")
        {
            getImage= databaseReference.child("images").child("hp")
            rImage?.setBackgroundResource(R.drawable.hp);}
        else if(data=="dfr")
        {
            getImage= databaseReference.child("images").child("dfr")
            rImage?.setBackgroundResource(R.drawable.dfr);}
        else if (data=="bod"){
            getImage= databaseReference.child("images").child("bod")
            rImage?.setBackgroundResource(R.drawable.bod);}
        else if (data=="sq"){
            getImage= databaseReference.child("images").child("sq")
            rImage?.setBackgroundResource(R.drawable.chest);}
        else if (data=="lun"){
            getImage= databaseReference.child("images").child("lun")
            rImage?.setBackgroundResource(R.drawable.lunge);}
        else if (data=="slcr"){
            getImage= databaseReference.child("images").child("slcr")
            rImage?.setBackgroundResource(R.drawable.slcr);}


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
                Toast.makeText(this@activity2, "Error Loading Image", Toast.LENGTH_SHORT).show()
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
                Toast.makeText(this@activity2, "Please add some data.", Toast.LENGTH_SHORT).show()
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
                        Toast.makeText(this@activity2, "data added", Toast.LENGTH_SHORT).show()
                    }

                    override fun onCancelled(error: DatabaseError) {
                        // if the data is not added or it is cancelled then
                        // we are displaying a failure toast message.
                        Toast.makeText(this@activity2, "Fail to add data $error", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        })
    }
}
