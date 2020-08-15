package com.tmw.foodparadise.api

import com.tmw.foodparadise.model.Category
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

    val retrofit:Retrofit?=null

    private val apiInterface: ApiInterface

    init {
        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        apiInterface=retrofit.create(ApiInterface::class.java)
    }

    fun getCategories(): Call<Category>{
        return apiInterface.getCategory("categories.php")
    }
}