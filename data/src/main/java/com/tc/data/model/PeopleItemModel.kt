package com.tc.data.model


import com.google.gson.annotations.SerializedName

data class PeopleItemModel(
    @SerializedName("people")
    val people: List<People?>? = listOf()
)