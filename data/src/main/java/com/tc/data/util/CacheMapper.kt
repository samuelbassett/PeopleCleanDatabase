package com.tc.data.util

import com.tc.data.model.PeopleModel
import com.tc.data.model.local.PeopleEntity
import javax.inject.Inject

class CacheMapper @Inject constructor() {

    fun mapFromEntity(entity: PeopleEntity): PeopleModel {
        return PeopleModel(
            firstName = entity.firstName,
            lastName = entity.lastName,
            dateOfBirth = entity.dateOfBirth,
            avatarImage = entity.avatarImage,
            role = entity.role
        )
    }

    fun mapToEntity(domainModel: PeopleModel): PeopleEntity {
        return PeopleEntity(
            firstName = domainModel.firstName,
            lastName = domainModel.lastName,
            dateOfBirth = domainModel.dateOfBirth,
            avatarImage = domainModel.avatarImage,
            role = domainModel.role
        )
    }

    fun mapFromEntityList(entities: List<PeopleEntity>): List<PeopleModel> {
        return entities.map { mapFromEntity(it) }
    }

    fun mapToEntityList(domainModels: List<PeopleModel>): List<PeopleEntity> {
        return domainModels.map { mapToEntity(it) }
    }
}
