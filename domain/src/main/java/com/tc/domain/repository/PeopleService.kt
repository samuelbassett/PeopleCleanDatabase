package com.tc.domain.repository

import com.tc.domain.model.local.People
import retrofit2.Response
import retrofit2.http.GET

interface PeopleService {
    @GET(ApiDetails.PEOPLE_ENDPOINT)
    suspend fun getAllPeople(): Response<List<People>>
}