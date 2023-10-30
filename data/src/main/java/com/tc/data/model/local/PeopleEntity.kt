package com.tc.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "people")
data class PeopleEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val avatarImage: String = "",
    val dateOfBirth: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val role: String = ""
)