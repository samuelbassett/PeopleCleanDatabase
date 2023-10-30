package com.tc.data.model.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PeopleDao {
    @Query("SELECT * FROM people")
    suspend fun getAllPeople(): List<PeopleEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(people: List<PeopleEntity>)

    @Query("SELECT * FROM people WHERE id = :personId")
    suspend fun getPersonById(personId: Int): PeopleEntity

    @Query("DELETE FROM people")
    suspend fun deleteAll()
}