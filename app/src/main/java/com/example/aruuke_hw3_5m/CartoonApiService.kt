package com.example.aruuke_hw3_5m

import com.example.aruuke_hw3_5m.models.RickMorty
import retrofit2.Call
import retrofit2.http.GET

interface CartoonApiService {
    @GET("character")
    fun fetchCharacters(): Call<RickMorty>
}