package com.example.travellingpackage

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Assigning ids to palettes
        val btnInventory = findViewById<Button>(R.id.btnInventory)
        val listView = findViewById<ListView>(R.id.listView)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // Receive data from Screen 1
        val items = intent.getStringArrayListExtra("itemsList") ?: arrayListOf()

        // SHOW LIST ONLY WHEN BUTTON IS CLICKED
        btnInventory.setOnClickListener {

            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                items
            )

            listView.adapter = adapter
        }

        // Returns you back to main screen
        btnBack.setOnClickListener {
            finish()
        }
    }
}
