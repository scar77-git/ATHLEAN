package com.example.testapp
import android.content.Intent
import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.DrawableCompat
import kotlinx.android.synthetic.main.login.*


class login1 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        val pref = getSharedPreferences("ActivityPREF", MODE_PRIVATE)
        val edt = pref.edit()
        edt.putBoolean("activity_executed", true)
        edt.commit()
        window.statusBarColor = 0x000000
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
        actionBar?.hide();

        val num1 = findViewById<EditText>(R.id.email)
        val num2 = findViewById<EditText>(R.id.password)
        val imgbtn = findViewById<Button>(R.id.login_button)
        imgbtn.setOnClickListener {
            if (num1.text.toString().isEmpty() || num2.text.toString().isEmpty()) {
                Toast.makeText(applicationContext,
                    "INVALID", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(applicationContext,
                    "WELCOME",
                    Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        val button2: Button = findViewById(R.id.forgot_password)
        button2.setOnClickListener {
            val intent = Intent(this, registration::class.java)
            startActivity(intent)


        }
        //toolbar = findViewById(R.id.toolbar_login)
        //setSupportActionBar(toolbar)

       // email.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.email, 0, 0, 0)
        //password.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.password, 0, 0, 0)


        email.addTextChangedListener(loginTextWatcher)
        password.addTextChangedListener(loginTextWatcher)


        email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int)
            {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int)
            {

            }

            override fun afterTextChanged(s: Editable)
            {
                if (s.length > 5)
                {
                    var drawable = resources.getDrawable(R.drawable.email) //Your drawable image
                    drawable = DrawableCompat.wrap(drawable!!)
                    DrawableCompat.setTint(drawable, resources.getColor(R.color.white)) // Set whatever color you want
                    DrawableCompat.setTintMode(drawable, PorterDuff.Mode.SRC_IN)
                    email.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null)
                    email.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(R.drawable.email),
                        null, resources.getDrawable(R.drawable.cancel), null)
                }
                else if (s.length == 0)
                {
                    //email.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.email,
                       // 0, 0, 0)
                    var drawable = resources.getDrawable(R.drawable.message) //Your drawable image
                    drawable = DrawableCompat.wrap(drawable!!)
                    DrawableCompat.setTint(drawable, resources.getColor(R.color.white)) // Set whatever color you want
                    DrawableCompat.setTintMode(drawable, PorterDuff.Mode.SRC_IN)
                    email.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null)
                    email.setCompoundDrawablesWithIntrinsicBounds(
                        resources.getDrawable(R.drawable.email),
                        null, null, null
                    )
                }
            }
        })

        password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int)
            {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int)
            {

            }

            override fun afterTextChanged(s: Editable)
            {
                if (s.length >= 8)
                {
                    var drawable = resources.getDrawable(R.drawable.password) //Your drawable image
                    drawable = DrawableCompat.wrap(drawable!!)
                    DrawableCompat.setTint(drawable, resources.getColor(R.color.white)) // Set whatever color you want
                    DrawableCompat.setTintMode(drawable, PorterDuff.Mode.SRC_IN)
                    password.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null)
                    password.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(R.drawable.password),
                        null, resources.getDrawable(R.drawable.cancel), null)
                }
                else if (s.length == 0)
                {
                   // password.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.password,
                       // 0, 0, 0)
                    var drawable = resources.getDrawable(R.drawable.password) //Your drawable image
                    drawable = DrawableCompat.wrap(drawable!!)
                    DrawableCompat.setTint(drawable, resources.getColor(R.color.white)) // Set whatever color you want
                    DrawableCompat.setTintMode(drawable, PorterDuff.Mode.SRC_IN)
                    password.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null)
                    password.setCompoundDrawablesWithIntrinsicBounds(resources.getDrawable(R.drawable.password),
                        null, null, null
                    )
                }
            }
        })

        email.setOnTouchListener(View.OnTouchListener { v, event ->

            if (event.action == MotionEvent.ACTION_DOWN)
            {
                if (email.getCompoundDrawables().get(2) != null)
                {
                    if (event.x >= email.getRight() - email.getLeft() -
                        email.getCompoundDrawables().get(2).getBounds().width())
                    {
                        if (email.getText().toString() != "")
                        {
                            email.setText("")
                        }
                    }
                }
            }
            false
        })

        password.setOnTouchListener(View.OnTouchListener {
            v, event ->

            if (event.action == MotionEvent.ACTION_DOWN)
            {
                if (password.getCompoundDrawables().get(2) != null)
                {
                    if (event.x >= password.getRight() - password.getLeft() -
                        password.getCompoundDrawables().get(2).getBounds().width()
                    )
                    {
                        if (password.getText().toString() != "")
                        {
                            password.setText("")
                        }
                    }
                }
            }
            false
        })

        remember_password.setOnClickListener(View.OnClickListener {

            if (!(remember_password.isSelected)) {
                remember_password.isChecked = true
                remember_password.isSelected = true
            } else {
                remember_password.isChecked = false
                remember_password.isSelected = false
            }
        })
    }

    private val loginTextWatcher: TextWatcher = object : TextWatcher {

        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int)
        {


        }

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int)
        {


        }

        override fun afterTextChanged(s: Editable)
        {
            val mUsername: String = email.getText().toString().trim()
            val mPassword: String = password.getText().toString().trim()
            val t = !mUsername.isEmpty() && !mPassword.isEmpty()
            if (t)
            {
                login_button.setBackgroundResource(R.drawable.ellipse)
            }
            else
            {
                login_button.setBackgroundResource(R.drawable.ellipse)
            }

        }
    }

    override fun onStart()
    {
        super.onStart()
        val mUsername: String = email.getText().toString().trim()
        val mPassword: String = password.getText().toString().trim()
        val t = !mUsername.isEmpty() && !mPassword.isEmpty()
        if (t)
        {
            login_button.setBackgroundResource(R.drawable.ellipse)
        }
        else
        {
            login_button.setBackgroundResource(R.drawable.ellipse)
        }
    }

    }
