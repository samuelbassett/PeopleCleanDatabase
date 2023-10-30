package com.tc.domain.usecase

import com.tc.data.model.local.PeopleEntity
import com.tc.data.model.repository.PeopleRepository
import com.tc.data.model.repository.PeopleRepositoryImpl
import javax.inject.Inject

class FetchPeopleByIdUseCaseImpl @Inject constructor(
    private val peopleRepository: PeopleRepositoryImpl
): FetchPeopleByIdUseCase {
    override suspend fun execute(id: Int): PeopleEntity {
        return peopleRepository.getPersonById(id)
    }
}