package com.tc.domain.usecase

import com.tc.data.model.local.PeopleEntity

interface FetchAllPeopleUseCase {
    suspend fun execute(): List<PeopleEntity>
}