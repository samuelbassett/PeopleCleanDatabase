package com.tc.domain.model.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [People::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun peopleDao(): PeopleDao
}
