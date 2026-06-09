package com.example.travellingpackage

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val itemsList = mutableListOf<String>()

    private var counter = 0
    private val maxSize = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickMeButton = findViewById<Button>(R.id.clickMeButton)
        val btnOpenBag = findViewById<Button>(R.id.btnOpenBag)
        val btnExit = findViewById<Button>(R.id.btnExit)

        val txtAdd = findViewById<EditText>(R.id.txtAdd)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        // ADD ITEM
        clickMeButton.setOnClickListener {

            val input = txtAdd.text.toString()

            if (input.isNotEmpty()) {

                if (counter < maxSize) {

                    itemsList.add(input)
                    counter++

                    tvStatus.text = "Stored: $counter/$maxSize"

                    txtAdd.text.clear()

                    if (counter == maxSize) {
                        Toast.makeText(this, "List is full", Toast.LENGTH_LONG).show()
                        clickMeButton.isEnabled = false
                    }
                }
            }
        }

        // OPEN SCREEN 2 AND SEND DATA
        btnOpenBag.setOnClickListener {

            val intent = Intent(this, MainActivity2::class.java)

            intent.putStringArrayListExtra("itemsList", ArrayList(itemsList))

            startActivity(intent)
        }

        // EXIT APP
        btnExit.setOnClickListener {
            finishAffinity()
        }
    }
}