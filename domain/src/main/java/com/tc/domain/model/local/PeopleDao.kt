package com.tc.domain.model.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PeopleDao {
    @Query("SELECT * FROM people")
    fun getAllPeople(): List<People>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(people: People): Long

    @Query("SELECT * FROM people WHERE id = :personId")
    suspend fun getPersonById(personId: Int): People

    @Insert
    fun insertAll(peopleList: List<People>)

    @Query("DELETE FROM people")
    suspend fun deleteAll()
}