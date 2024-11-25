# RoomDatabaseContactsApp

This is an Android application that demonstrates how to use **Room Database** with **Kotlin Coroutines** to manage a simple contact list. The app allows users to add, update, delete, and retrieve contacts using Room persistence library.

## Features

- **Room Database** to persist contact data.
- **Kotlin Coroutines** for background operations (inserting, updating, deleting).
- **LiveData** to observe changes in the database and update the UI automatically.
- Simple contact management UI with a button to fetch all contacts.
- **Edge-to-Edge** design support (using `ViewCompat` for proper padding on modern devices).

## Architecture

- **Room Database**: A local database to store contact details like name and phone number.
- **Dao (Data Access Object)**: Interface to define methods for database operations such as inserting, updating, deleting, and querying contacts.
- **LiveData**: Used to observe the data from the database and update the UI accordingly.
- **Coroutines**: Used for performing long-running database operations in the background to ensure smooth performance.

## Setup Instructions

1. Clone the repository:

    ```bash
    git clone https://github.com/yourusername/RoomDatabaseContactsApp.git
    ```

2. Open the project in **Android Studio**.

3. Make sure you have **Kotlin** and **Room dependencies** included in your `build.gradle` files:

    - In your `app/build.gradle`:

      ```gradle
      dependencies {
          implementation(libs.androidx.room.runtime)
          ksp("androidx.room:room-compiler:2.5.0")
          implementation(libs.androidx.room.ktx)
          implementation(libs.kotlinx.coroutines.core)
          implementation(libs.kotlinx.coroutines.android)
      }
      ```

4. Sync the project with Gradle.

5. Run the app on an emulator or physical device.

## Code Explanation

### Room Database

The `ContactDatabase` class is a singleton class that provides access to the Room database. It uses `@Database` annotation to define the entities (Contact table) and database version.

```kotlin
@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao
}
