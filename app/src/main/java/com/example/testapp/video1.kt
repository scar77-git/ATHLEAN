package com.example.testapp
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
class video1 : Activity() {
    var data: String? = null
    var data2:String?=null
    var simpleVideoView: VideoView? = null
    var mediaControls: MediaController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.video)
        // Find your VideoView in your video_main.xml layout
        simpleVideoView = findViewById<View>(R.id.videoview) as VideoView
        data = intent.getStringExtra("val_1")
        if (mediaControls == null) {
            // create an object of media controller class
            mediaControls = MediaController(this@video1)
            mediaControls!!.setAnchorView(simpleVideoView)
        }
        // set the media controller for video view
        simpleVideoView!!.setMediaController(mediaControls)
        // set the uri for the video view
        if(data=="pushups")
        {
            simpleVideoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.exercise2))
            }
        else if(data=="decpushups")
        {
            simpleVideoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.decpushups))
            }
        else if (data=="fdcp"){
            simpleVideoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.fdp))
            }
        else if (data=="planks"){
            simpleVideoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.planks))
            }
        else if (data=="crunches"){
            simpleVideoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.crunches))
            }
        else if (data=="legraises"){
            simpleVideoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.legraises))
            }
        if(data=="hp")
        {
            simpleVideoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.exercise2))
        }
        else if(data=="dfr")
        {
            simpleVideoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.decpushups))
        }
        else if (data=="bod"){
            simpleVideoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.fdp))
        }
        else if (data=="sq"){
            simpleVideoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.planks))
        }
        else if (data=="lun"){
            simpleVideoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.crunches))
        }
        else if (data=="slcr"){
            simpleVideoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.legraises))
        }
        if(data=="ac")
        {
            simpleVideoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.exercise2))
        }
        else if(data=="td")
        {
            simpleVideoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.decpushups))
        }
        else if (data=="sp"){
            simpleVideoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.fdp))
        }
        else if (data=="sk"){
            simpleVideoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.planks))
        }
        else if (data=="hk"){
            simpleVideoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.crunches))
        }
        else if (data=="jj"){
            simpleVideoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.legraises))
        }
        // start a video
        simpleVideoView!!.start()

        // implement on completion listener on video view
        simpleVideoView!!.setOnCompletionListener {
            val intent = Intent(this, activity1::class.java)
            startActivity(intent) // display a toast when an video is completed
        }
        simpleVideoView!!.setOnErrorListener { mp, what, extra ->
            Toast.makeText(
                applicationContext,
                "Oops An Error Occur While Playing Video...!!!",
                Toast.LENGTH_LONG
            ).show() // display a toast when an error is occured while playing an video
            false
        }
    }
}