package com.example.rastiapp.data.model

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("name") val name: String,
    @SerializedName("id") val id: Int
)