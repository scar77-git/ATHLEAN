package com.example.testapp

import android.app.Activity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.*


class timer1 : Activity(), View.OnClickListener {
    var i = -1
    var mProgressBar: ProgressBar? = null
    var mProgressBar1: ProgressBar? = null
    private var buttonStartTime: Button? = null
    private var buttonStopTime: Button? = null
    private var edtTimerValue: EditText? = null
    private var textViewShowTime: TextView? = null
    private var countDownTimer: CountDownTimer? = null
    private var totalTimeCountInMilliseconds: Long = 0
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.timer)
        buttonStartTime = findViewById<View>(R.id.button_timerview_start) as Button
        buttonStopTime = findViewById<View>(R.id.button_timerview_stop) as Button
        textViewShowTime = findViewById<View>(R.id.textView_timerview_time) as TextView
        edtTimerValue = findViewById<View>(R.id.textview_timerview_back) as EditText
        buttonStartTime!!.setOnClickListener(this)
        buttonStopTime!!.setOnClickListener(this)
        mProgressBar = findViewById<View>(R.id.progressbar_timerview) as ProgressBar
        mProgressBar1 = findViewById<View>(R.id.progressbar1_timerview) as ProgressBar
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_timerview_start) {
            setTimer()
            buttonStartTime!!.visibility = View.INVISIBLE
            buttonStopTime!!.visibility = View.VISIBLE
            mProgressBar!!.visibility = View.INVISIBLE
            startTimer()
            mProgressBar1!!.visibility = View.VISIBLE
        } else if (v.id == R.id.button_timerview_stop) {
            countDownTimer!!.cancel()
            countDownTimer!!.onFinish()
            mProgressBar1!!.visibility = View.GONE
            mProgressBar!!.visibility = View.VISIBLE
            edtTimerValue!!.visibility = View.VISIBLE
            buttonStartTime!!.visibility = View.VISIBLE
            buttonStopTime!!.visibility = View.INVISIBLE
        }
    }

    private fun setTimer() {
        var time = 0
        if (edtTimerValue!!.text.toString() != "") {
            time = edtTimerValue!!.text.toString().toInt()
        } else Toast.makeText(this@timer1, "Please Enter time in seconds...",
                Toast.LENGTH_LONG).show()
        totalTimeCountInMilliseconds = time * 1000.toLong()
        mProgressBar1!!.max = time * 1000
    }

    private fun startTimer() {
        countDownTimer = object : CountDownTimer(totalTimeCountInMilliseconds, 1) {
            override fun onTick(leftTimeInMilliseconds: Long) {
                val seconds = leftTimeInMilliseconds / 1000
                mProgressBar1!!.progress = leftTimeInMilliseconds.toInt()
                textViewShowTime!!.text = String.format("%02d", seconds / 60) + ":" + String.format("%02d", seconds % 60)
            }

            override fun onFinish() {
                textViewShowTime!!.text = "00:00"
                textViewShowTime!!.visibility = View.VISIBLE
                buttonStartTime!!.visibility = View.VISIBLE
                buttonStopTime!!.visibility = View.VISIBLE
                mProgressBar!!.visibility = View.VISIBLE
                mProgressBar1!!.visibility = View.GONE
            }
        }.start()
    }
}
