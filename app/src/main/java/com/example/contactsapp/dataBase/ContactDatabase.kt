package com.example.contactsapp.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contactsapp.dataClass.Contact
import com.example.contactsapp.dataClass.ContactDao


@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {

    abstract fun contactDao(): ContactDao

    companion object {

        //volatile help --> when instance variable write or assing
        // then other thread get notify that variable is updated

        //private filed that hold the database
        @Volatile
        private var INSTANCE: ContactDatabase? = null

        // public function to access the database
        fun getDatabase(context: Context): ContactDatabase {
            if (INSTANCE == null) {
                // used this so that only one instance will be created only
                // if multiple thread try to access database also then only one instance will be created
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(
                            context.applicationContext,
                            ContactDatabase::class.java,
                            "contactDB"
                        )
                            .build()
                }

            }
            return INSTANCE!!
        }
    }
}