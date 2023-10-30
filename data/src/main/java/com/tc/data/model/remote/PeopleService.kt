package com.tc.data.model.remote

import com.tc.data.model.PeopleItemModel
import retrofit2.Response
import retrofit2.http.GET

interface PeopleService {
    @GET(ApiDetails.PEOPLE_ENDPOINT)
    suspend fun getAllPeople(): Response<PeopleItemModel>
}