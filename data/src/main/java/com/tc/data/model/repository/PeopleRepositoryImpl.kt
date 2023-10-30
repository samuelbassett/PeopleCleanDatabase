package com.tc.data.model.repository


import com.tc.data.util.CacheMapper
import com.tc.data.model.remote.PeopleService
import com.tc.data.model.local.PeopleDao
import com.tc.data.model.local.PeopleEntity
import javax.inject.Inject

class PeopleRepositoryImpl @Inject constructor(
    private val service: PeopleService,
    private val peopleDao: PeopleDao,
    private val cacheMapper: CacheMapper
) : PeopleRepository {

    override suspend fun getAllPeople(): List<PeopleEntity> {
        if (peopleDao.getAllPeople().isEmpty()) {
            val response = service.getAllPeople()
            response.isSuccessful.let {
                peopleDao.insertAll(cacheMapper.mapToEntityList(response.body()!!.people))
                return peopleDao.getAllPeople()
            }
        } else {
            return peopleDao.getAllPeople()
        }
    }

    override suspend fun getPersonById(id: Int): PeopleEntity {
        return peopleDao.getPersonById(id)
    }
}

