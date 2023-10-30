package com.tc.data.model.repository

import com.tc.data.model.local.PeopleEntity

interface PeopleRepository {
    suspend fun getAllPeople(): List<PeopleEntity>
    suspend fun getPersonById(id: Int): PeopleEntity
}