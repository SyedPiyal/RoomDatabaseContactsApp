package com.example.contactsapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contactsapp.dataBase.ContactDatabase
import com.example.contactsapp.dataClass.Contact
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var database: ContactDatabase
    private lateinit var getButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        getButton = findViewById(R.id.button)

        database = ContactDatabase.getDatabase(this)

        // (globalScope)  used coroutines to call the function
        //add data in database
        GlobalScope.launch {
            database.contactDao().insertContact(Contact(0, "John", "0124652555"))

        }

        getButton.setOnClickListener {
            database.contactDao().getAllContact().observe(this, Observer {
                Log.d("Adding data", it.toString())
            })
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}