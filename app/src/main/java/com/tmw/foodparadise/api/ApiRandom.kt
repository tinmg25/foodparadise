package com.tmw.foodparadise.api

import com.tmw.foodparadise.model.Random
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiRandom {
    @GET("random.php")
    fun getRandom(
        @Query("random.php") random: String
    ): Call<Random>
}
