package com.example.testapp
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class login1 : AppCompatActivity() {
   // val isFirstRun = getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE)
           // .getBoolean("isFirstRun", true)
    private lateinit var auth: FirebaseAuth

    private lateinit var emailEt: EditText
    private lateinit var passwordEt: EditText

    private lateinit var signupBtn: Button
    private lateinit var loginBtn: Button

    private lateinit var resetPasswordTv: TextView
   // var firebaseDatabase: FirebaseDatabase? = null
    // creating a variable for our Database
    // Reference for Firebase.
    //var databaseReference: DatabaseReference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        emailEt = findViewById(R.id.email_edt_text)
        passwordEt = findViewById(R.id.pass_edt_text)

        signupBtn = findViewById(R.id.signup_btn)
        loginBtn = findViewById(R.id.login_btn)

        resetPasswordTv = findViewById(R.id.reset_pass_tv)

        auth = FirebaseAuth.getInstance()
        //firebaseDatabase = FirebaseDatabase.getInstance()

        // below line is used to get reference for our database.
        //databaseReference = firebaseDatabase!!.getReference("user1")
        //val info=user()

        loginBtn.setOnClickListener {
            var email: String = emailEt.text.toString()
            var password: String = passwordEt.text.toString()

            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                Toast.makeText(this@login1, "Please fill all the fields", Toast.LENGTH_LONG).show()
            } else{
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener { task ->
                    if(task.isSuccessful) {
                        Toast.makeText(this, "Successfully Logged In", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }else {
                        Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()
                    }
                })
            }
        }

        signupBtn.setOnClickListener{
            val intent = Intent(this, registration::class.java)
            startActivity(intent)
            finish()
        }


    }
}


