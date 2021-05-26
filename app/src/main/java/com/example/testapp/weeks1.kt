package com.example.testapp
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import java.util.*


internal class weeks1 : Activity(), OnItemSelectedListener {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weeks)

        // Spinner element
        val spinner = findViewById<View>(R.id.spinner) as Spinner

        // Spinner click listener
        spinner.onItemSelectedListener = this
        val button7: Button = findViewById(R.id.nxt)
        button7.setOnClickListener {

            val intent = Intent(this, workout::class.java)
            startActivity(intent)


        }
        // Spinner Drop down elements
        val categories: MutableList<String> = ArrayList()
        categories.add("DAY 1")
        categories.add("DAY 2")
        categories.add("DAY 3")
        categories.add("DAY 4")
        categories.add("DAY 5")
        categories.add("DAY 6")
        // Creating adapter for spinner
        val dataAdapter = ArrayAdapter(this, R.layout.simple_spinner_item, categories)

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)

        // attaching data adapter to spinner
        spinner.adapter = dataAdapter
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        // On selecting a spinner item
        val item = parent.getItemAtPosition(position).toString()
        (parent.getChildAt(0) as TextView).setTextColor(Color.WHITE)
        // Showing selected spinner item

        Toast.makeText(parent.context, "Selected: $item", Toast.LENGTH_LONG).show()
    }

    override fun onNothingSelected(arg0: AdapterView<*>?) {
        // TODO Auto-generated method stub
    }

}