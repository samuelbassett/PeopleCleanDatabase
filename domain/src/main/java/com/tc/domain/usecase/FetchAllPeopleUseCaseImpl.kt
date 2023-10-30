package com.tc.domain.usecase

import com.tc.domain.repository.PeopleService
import com.tc.domain.model.local.People
import com.tc.domain.model.local.PeopleDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchAllPeopleUseCaseImpl @Inject constructor(
    private val service: PeopleService,
    private val personDao: PeopleDao
): FetchAllPeopleUseCase {
    override fun execute(): Flow<List<People>> {
        return flow {
            try {
                val response = service.getAllPeople()

                if (response.isSuccessful && response.body() != null) {
                    val peopleList = response.body()!!
                    personDao.deleteAll()
                    personDao.insertAll(peopleList)
                    emit(peopleList)
                } else {
                    val localData = personDao.getAllPeople()
                    if (localData.isNotEmpty()) {
                       emit(localData)
                    } else {
                        emit(emptyList())
                    }
                }
            } catch (e: Exception) {
                val localData = personDao.getAllPeople()
                if (localData.isNotEmpty()) {
                    emit(localData)
                } else {
                    e.printStackTrace()
                    emit(emptyList())
                }
            }
        }
    }
}
