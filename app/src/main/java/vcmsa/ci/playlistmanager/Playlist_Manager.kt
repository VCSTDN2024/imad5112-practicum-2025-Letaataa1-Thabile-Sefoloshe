package vcmsa.ci.playlistmanager

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.lang.StringBuilder
import java.util.ArrayList
import kotlin.system.exitProcess

class Playlist_Manager : AppCompatActivity() {

    private var song = mutableListOf<String>()
    private var artist = mutableListOf<String>()
    private var rating = mutableListOf<Int>()
    private var comment = mutableListOf<String>()

    @RequiresApi(Build.VERSION_CODES.R)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_playlist_manager)

        val addBtn = findViewById<Button>(R.id.addBtn)
        val reviewBtn = findViewById<Button>(R.id.reviewBtn)
        val exitBtn2 = findViewById<Button>(R.id.exitBtn2)

        addBtn.setOnClickListener {
            displayInformation()
        }

        reviewBtn.setOnClickListener {
            if (song.isNotEmpty()) {

                val intent = Intent(this, Review::class.java)
                intent.putStringArrayListExtra("song", ArrayList(song))
                intent.putStringArrayListExtra("artist", ArrayList(artist))
                intent.putIntegerArrayListExtra("rating", ArrayList(rating))
                intent.putStringArrayListExtra("comment", ArrayList(comment))
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "Packing list is empty",Toast.LENGTH_SHORT).show()
            }
        }

        exitBtn2.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }
    }

    @RequiresApi(Build.VERSION_CODES.R)
    fun displayInformation() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Add New Information")

        val view = layoutInflater.inflate(R.layout.add_information, null)
        val songText = findViewById<EditText>(R.id.songText)
        val artistText = findViewById<EditText>(R.id.artisText)
        val ratingText = findViewById<EditText>(R.id.ratingText)
        val commentsText = findViewById<EditText>(R.id.commentsText)

        builder.setView(view)

        builder.setPositiveButton("Add") { dialog, _ ->
            val song = songText.text.toString().trim()
            val artist = artistText.text.toString().trim()
            val rating = ratingText.text.toString().trim()
            val comment = commentsText.text.toString().trim()

            if (song.isEmpty() || artist.isEmpty() || rating.isEmpty()) {
                Toast.makeText(this, "Song title, Artist name and Rating cannot be empty!", Toast.LENGTH_SHORT).show()
                return@setPositiveButton
            }

            val ratings = rating.toIntOrNull()
            if (ratings == null || ratings <= 0) {
                Toast.makeText(this, "Invalid rating. Please enter a number greater then 0!", Toast.LENGTH_SHORT).show()
                return@setPositiveButton
            }

            song.add(song)
            this.artist.add(artist)
            this.rating.add(ratings)
            this.comment.add(comment)

            Toast.makeText(this, "$song added information to packing list",Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.cancel()
        }

        builder.show()
    }
}

private fun String.add(song: String) {
    TODO("Not yet implemented")
}



