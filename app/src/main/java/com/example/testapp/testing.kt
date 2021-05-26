package com.example.testapp

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


class testing : AppCompatActivity() {
    // creating variables for
    // EditText and buttons.
    private var employeeNameEdt: EditText? = null
    private var employeePhoneEdt: EditText? = null
    private var employeeAddressEdt: EditText? = null
    private var sendDatabtn: Button? = null

    // creating a variable for our
    // Firebase Database.
    var firebaseDatabase: FirebaseDatabase? = null

    // creating a variable for our Database
    // Reference for Firebase.
    var databaseReference: DatabaseReference? = null

    // creating a variable for
    // our object class
    var employeeInfo: user? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.testing1)

        // initializing our edittext and button
        employeeNameEdt = findViewById(R.id.idEdtEmployeeName)
        employeePhoneEdt = findViewById(R.id.idEdtEmployeePhoneNumber)
        employeeAddressEdt = findViewById(R.id.idEdtEmployeeAddress)

        // below line is used to get the
        // instance of our FIrebase database.
        firebaseDatabase = FirebaseDatabase.getInstance()

        // below line is used to get reference for our database.
        databaseReference = firebaseDatabase!!.getReference("user")

        // initializing our object
        // class variable.
        employeeInfo= user()
        sendDatabtn = findViewById(R.id.idBtnSendData)

        // adding on click listener for our button.
        sendDatabtn?.setOnClickListener(View.OnClickListener {
            // getting text from our edittext fields.
            val name = employeeNameEdt?.getText().toString()
            val phone = employeePhoneEdt?.getText().toString()
            val address = employeeAddressEdt?.getText().toString()

            // below line is for checking weather the
            // edittext fields are empty or not.
            if (TextUtils.isEmpty(name) && TextUtils.isEmpty(phone) && TextUtils.isEmpty(address)) {
                // if the text fields are empty
                // then show the below message.
                Toast.makeText(this@testing, "Please add some data.", Toast.LENGTH_SHORT).show()
            } else {
                // else call the method to add
                // data to our database.
                addDatatoFirebase(name, phone, address)
            }
        })
    }

    private fun addDatatoFirebase(name: String, phone: String, address: String) {
        // below 3 lines of code is used to set
        // data in our object class.
        employeeInfo?.setEmployeeName(name)
        employeeInfo?.setEmployeeContactNumber(phone)
        employeeInfo?.setflag(address)

        // we are use add value event listener method
        // which is called with database reference.
        databaseReference!!.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    // inside the method of on Data change we are setting
                    // our object class to our database reference.
                    // data base reference will sends data to firebase.
                    val uid :String= FirebaseAuth.getInstance().getCurrentUser().getUid()
                    databaseReference!!.child(uid).setValue(employeeInfo)

                    // after adding this data we are showing toast message.
                    Toast.makeText(this@testing, "data added", Toast.LENGTH_SHORT).show()
                }

            override fun onCancelled(error: DatabaseError) {
                // if the data is not added or it is cancelled then
                // we are dis
                Toast.makeText(this@testing, "Fail to add data", Toast.LENGTH_SHORT).show()
            }
        })
    }
}