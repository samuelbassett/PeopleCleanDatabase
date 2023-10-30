package com.tc.data.model.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PeopleEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun peopleDao(): PeopleDao
}
