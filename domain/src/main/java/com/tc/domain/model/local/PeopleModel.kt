package com.tc.domain.model.local


import com.google.gson.annotations.SerializedName

data class PeopleModel(
    @SerializedName("avatarImage")
    val avatarImage: String? = "",
    @SerializedName("dateOfBirth")
    val dateOfBirth: String? = "",
    @SerializedName("firstName")
    val firstName: String? = "",
    @SerializedName("lastName")
    val lastName: String? = "",
    @SerializedName("role")
    val role: String? = ""
)