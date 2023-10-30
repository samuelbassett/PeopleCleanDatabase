package com.tc.domain.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "people")
data class People(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0, // Auto-incrementing ID
    val firstName: String,
    val lastName: String,
    val avatarImage: String,
    val dateOfBirth: String,
    val role: String
)