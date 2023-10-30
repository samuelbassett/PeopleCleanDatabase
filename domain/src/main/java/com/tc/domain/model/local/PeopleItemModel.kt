package com.tc.domain.model.local


import com.google.gson.annotations.SerializedName

data class PeopleItemModel(
    @SerializedName("people")
    val people: List<PeopleModel?>? = listOf()
)