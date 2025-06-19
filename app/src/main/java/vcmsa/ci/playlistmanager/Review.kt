package vcmsa.ci.playlistmanager

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Review : AppCompatActivity() {

    private lateinit var song: ArrayList<String>
    private lateinit var artist: ArrayList<String>
    private lateinit var rating: ArrayList<Int>
    private lateinit var comments: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review)

        val averageBtn = findViewById<Button>(R.id.averageBtn)
        val displayBtn = findViewById<Button>(R.id.displayBtn)
        val backBtn = findViewById<Button>(R.id.backBtn)

        song = intent.getStringArrayListExtra("song") ?: arrayListOf()
        artist = intent.getStringArrayListExtra("category") ?: arrayListOf()
        rating = intent.getIntegerArrayListExtra("rating") ?: arrayListOf()
        comments = intent.getStringArrayListExtra("comment") ?: arrayListOf()

        averageBtn.setOnClickListener {

        }

        displayBtn.setOnClickListener {
            dislayPackingList()
        }

        backBtn.setOnClickListener {
            val intent = Intent(this, Playlist_Manager::class.java)
            startActivity(intent)
        }
    }

    fun dislayPackingList() {

        val stringBuilder = StringBuilder()
        val TVdisplay = findViewById<TextView>(R.id.TVdisplay)

        if (song.isNotEmpty()) {
            for (i in song.indices) {
                stringBuilder.append("song: ${song[i]}\n")
                stringBuilder.append("artist: ${artist[i]}\n")
                stringBuilder.append("rating: ${rating[i]}\n")
                stringBuilder.append("comments: ${comments[i]}\n\n")

            }
            TVdisplay.text = stringBuilder.toString()
        } else {
            TVdisplay.text = "Packing list is empty"
        }
    }
}