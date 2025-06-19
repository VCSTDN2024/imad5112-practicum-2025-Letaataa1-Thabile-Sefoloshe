package vcmsa.ci.playlistmanager

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val startBtn = findViewById<Button>(R.id.startBtn)
        val exitBtn = findViewById<Button>(R.id.exitBtn)

        startBtn.setOnClickListener {
            val intent = Intent(this, Playlist_Manager::class.java)
            startActivity(intent)
        }

        exitBtn.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }
    }
}