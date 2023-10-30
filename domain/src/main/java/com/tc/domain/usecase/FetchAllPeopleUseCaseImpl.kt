package com.tc.domain.usecase

import com.tc.data.model.local.PeopleEntity
import com.tc.data.model.repository.PeopleRepository
import javax.inject.Inject

class FetchAllPeopleUseCaseImpl @Inject constructor(
    private val peopleRepository: PeopleRepository
) : FetchAllPeopleUseCase {
    override suspend fun execute(): List<PeopleEntity> = peopleRepository.getAllPeople()
}