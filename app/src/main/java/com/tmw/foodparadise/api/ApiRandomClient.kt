package com.tmw.foodparadise.api

import com.tmw.foodparadise.model.Random
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiRandomClient {
    private val BASE_URL = "https://www.themealdb.com/api/json/v1/"

    var retrofit: Retrofit? = null

    val apiRandom: ApiRandom

    init {
        var retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()

        apiRandom = retrofit.create(ApiRandom::class.java)
    }

    fun getRandom(): Call<Random> {
        return apiRandom.getRandom("random.php")
    }
}