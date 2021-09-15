package com.example.rickandmorty

import retrofit2.Call
import retrofit2.http.GET

interface RickAndMortyService {
    @GET("/api/character")
    fun getAllCharacters(): Call<CharactherResponse>
}