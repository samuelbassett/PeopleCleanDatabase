package com.tc.domain.usecase

import com.tc.domain.model.local.People
import kotlinx.coroutines.flow.Flow

interface FetchAllPeopleUseCase {
    fun execute(): Flow<List<People>>
}