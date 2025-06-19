package com.example.songplaylist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class PackingList : AppCompatActivity() {

    private lateinit var title: ArrayList<String>
    private lateinit var artists: ArrayList<String>
    private lateinit var rating: ArrayList<Int>
    private lateinit var comments: ArrayList<String>
    private lateinit var displayTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_playlist)

        title = intent.getStringArrayListExtra("title") ?: arrayListOf()
        artists= intent.getStringArrayListExtra("artists") ?: arrayListOf()
        rating = intent.getIntegerArrayListExtra("ratings") ?: arrayListOf()
        comments = intent.getStringArrayListExtra("comments") ?: arrayListOf()


        val displayAllButton: Button = findViewById(R.id.buttonDisplayalistofsongs)
        val displayRatingButton: Button = findViewById(R.id.Rating1to5EditTextText3)
        val ReturntomainButton: Button = findViewById(R.id.)
        val exitButton: Button = findViewById(R.id.buttonExit)

        displayAllButton.setOnClickListener {
            displayPackingList()
        }
        displayButton.setOnClickListener {
            displayItemsWithQuantity()
        }

        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        exitButton.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }
    }
    private fun displayPackingList() {
        val stringBuilder = StringBuilder()
        if (item.isNotEmpty()) {
            for (i in item.indices) {
                stringBuilder.append("Title: ${title[i]}\n")
                stringBuilder.append("Artist: ${artists[i]}\n")
                stringBuilder.append("Rating: ${rating[i]}\n")
                stringBuilder.append("Comments: ${comments[i]}\n\n")
            }
            displayTextView.text = stringBuilder.toString()
        } else {
            displayTextView.text = "Playlist is empty."
        }
    }
    private fun displayItemsWithQuantity() {
        val stringBuilder = StringBuilder()
        var found = false
        for (i in title.indices) {
            if (rating[i] 1 to 5) {
                stringBuilder.append("Title: ${title[i]} (Rating: ${rating[i]})\n
                found = true
            }
        }
        if (found) {
            displayTextView.text = stringBuilder.toString()
        } else {
            displayTextView.text = "No songs with a rating of more than 5."
        }
    }


class Playlist : AppCompatActivity() {

        }
    }
}