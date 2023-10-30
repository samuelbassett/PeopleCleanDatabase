package com.tc.data.model


import com.google.gson.annotations.SerializedName

data class People(
    @SerializedName("avatarImage")
    val avatarImage: String = "",
    @SerializedName("dateOfBirth")
    val dateOfBirth: String = "",
    @SerializedName("firstName")
    val firstName: String = "",
    @SerializedName("lastName")
    val lastName: String = "",
    @SerializedName("role")
    val role: String = ""
)