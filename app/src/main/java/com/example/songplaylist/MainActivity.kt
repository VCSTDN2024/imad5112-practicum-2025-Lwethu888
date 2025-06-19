package com.example.songplaylist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private val songtitle = mutableListOf<String>()
    private val artistname = mutableListOf<String>()
    private val rating1to5= mutableListOf<Int>()
    private val comments = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val addButton: Button = findViewById(R.id.addButton)
        val viewButton: Button = findViewById(R.id.viewButton)
        val exitButton: Button = findViewById(R.id.exitButton)

        addButton.setOnClickListener {
            showAddItemDialog()
        }
        viewButton.setOnClickListener {
            if (title.isNotEmpty()) {
                val intent = Intent(this, PackingList::class.java)
                intent.putStringArrayListExtra("item", ArrayList(title))
                intent.putStringArrayListExtra("category", ArrayList(artistname))
                intent.putIntegerArrayListExtra("quantity", ArrayList(rating1to5))
                intent.putStringArrayListExtra("comments", ArrayList(comments))
                startActivity(intent)
            } else {
                Snackbar.make(viewButton, "Packing list is empty. Add items first.", Snackbar.LENGTH_SHORT).show()
            }
        }
        exitButton.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }
    }

    private fun showAddItemDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Add New Item")

        val view = layoutInflater.inflate(R.layout.activity_dialog_add_playlist, null)
        val itemNameEditText: EditText = view.findViewById(R.id.SongTitleEditText)
        val categoryEditText: EditText = view.findViewById(R.id.ArtistNameEditTextText)
        val quantityEditText: EditText = view.findViewById(R.id.Rating1to5EditTextText3)
        val commentsEditText: EditText = view.findViewById(R.id.UsercommentsEditTextText4)

        builder.setView(view)
        builder.setPositiveButton("Add") { dialog, _ ->
            val itemName = itemNameEditText.text.toString().trim()
            val category = categoryEditText.text.toString().trim()
            val quantityStr = quantityEditText.text.toString().trim()
            val comments = commentsEditText.text.toString().trim()

            if (itemName.isEmpty() || category.isEmpty() || quantityStr.isEmpty()) {
                Snackbar.make(findViewById(android.R.id.content), "Item name, category, and quantity cannot be empty.", Snackbar.LENGTH_SHORT).show()
                return@setPositiveButton
    }


    }
    }
}