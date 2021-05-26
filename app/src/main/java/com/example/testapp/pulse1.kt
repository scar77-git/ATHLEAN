package com.example.testapp
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.gusakov.library.start
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.pulse.*

class pulse1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pulse)

        // when the user tap on the button this
        // function get invoked automatically.
            pulseCountDown.start {
                // when countdown ends a toast
                // will be shown to user
                Toast.makeText(this,
                    "warm up finished!", Toast.LENGTH_LONG).show()
                val intent = Intent(this, info1::class.java)
                startActivity(intent)

            }
    }
}