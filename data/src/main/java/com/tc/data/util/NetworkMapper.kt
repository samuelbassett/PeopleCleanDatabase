package com.tc.data.util

import com.tc.data.model.PeopleModel
import com.tc.data.model.local.PeopleEntity
import javax.inject.Inject

class NetworkMapper @Inject constructor() {

    fun mapToDomainModel(dto: PeopleEntity): PeopleModel {
        return PeopleModel(
            avatarImage = dto.avatarImage,
            dateOfBirth = dto.dateOfBirth,
            firstName = dto.firstName,
            lastName = dto.lastName,
            role = dto.role
        )
    }

    fun mapToDomainModelList(dtos: List<PeopleEntity>): List<PeopleModel> {
        return dtos.map { mapToDomainModel(it) }
    }
}
