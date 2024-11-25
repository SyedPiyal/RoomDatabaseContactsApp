package com.example.contactsapp.dataClass

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDao {

    // android suggest long timer work should be done in background thread for better performance
    // used suspend function to perform this task in background thread with coroutines
    @Insert
    suspend fun insertContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    //used live so that roomdb will automatically process this in background thread
    @Query("SELECT * FROM contact")
    fun getAllContact(): LiveData<List<Contact>>
}