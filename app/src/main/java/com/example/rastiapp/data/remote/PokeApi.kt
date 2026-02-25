package com.example.rastiapp.data.remote

import com.example.rastiapp.data.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {
    @GET("pokemon/{name}")
    suspend fun getPokemonByName(
        @Path("name") pokemon: String
    ): ApiResponse
}