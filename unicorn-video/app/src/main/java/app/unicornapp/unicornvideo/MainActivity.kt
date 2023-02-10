package app.unicornapp.unicornvideo

import android.net.Uri
import android.widget.MediaController
import android.widget.VideoView
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import app.unicornapp.unicornvideo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val videoView = findViewById<VideoView>(binding.videoView.id)
        // Creating MediaController
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        // Specify the location of the media file
        val uriPath: Uri = Uri.parse(
            "android.resource://" + packageName  + "/" + "raw/forbiggerfun"
        )

        // Setting MediaController and URI, then starting the videoView
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uriPath)
        videoView.requestFocus()
        videoView.start()

    }
}