package com.tc.domain.usecase

import com.tc.data.model.local.PeopleEntity

interface FetchPeopleByIdUseCase {
    suspend fun execute(id: Int): PeopleEntity
}