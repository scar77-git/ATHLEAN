package com.example.testapp
import android.content.Intent
import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Patterns
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.DrawableCompat
import kotlinx.android.synthetic.main.reg.*


class registration : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reg)
        window.statusBarColor = 0x000000
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
        actionBar?.hide();
        val num1 = findViewById<EditText>(R.id.email)
        val num2 = findViewById<EditText>(R.id.password)
        val num3 = findViewById<EditText>(R.id.confirm_pass)

        val imgbtn = findViewById<Button>(R.id.forgot_password)
        imgbtn.setOnClickListener {
            if (num1.text.toString().isEmpty() || num2.text.toString().isEmpty()) {
                Toast.makeText(applicationContext,
                        "EMPTY", Toast.LENGTH_SHORT).show()
            }
            else { if (isValidPassword(num2.getText().toString().trim())&&isValidEmail(num1.getText().toString())){
                       if(num2.text.toString()==num3.text.toString()){
                        Toast.makeText(applicationContext,
                                "VALID AND REGISTERED", Toast.LENGTH_SHORT).show()}
                        else{
                           Toast.makeText(applicationContext,
                                   "Password mismatching", Toast.LENGTH_SHORT).show()}
                       }
                    }

            }

        val button2: Button = findViewById(R.id.login_button)
        button2.setOnClickListener {
            val intent = Intent(this, login1::class.java)
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
                if (s.length != 0)
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
                if (s.length != 0)
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

        password.setOnTouchListener(View.OnTouchListener { v, event ->

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
            Toast.makeText(applicationContext,
                    "Password must contain atleast 4 letters" +
                            " ,atleast 1 special character" +
                            " ,atleast 1 upper case",
                    Toast.LENGTH_SHORT).show()
            false
        })

        /*remember_password.setOnClickListener(View.OnClickListener {

            if (!(remember_password.isSelected)) {
                remember_password.isChecked = true
                remember_password.isSelected = true
            } else {
                remember_password.isChecked = false
                remember_password.isSelected = false
            }
        })*/
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
    fun isValidPassword(password: String?) : Boolean {
        password?.let {
            val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$"
            val passwordMatcher = Regex(passwordPattern)

            return passwordMatcher.find(password) != null
        } ?: return false
    }
    fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }

}
