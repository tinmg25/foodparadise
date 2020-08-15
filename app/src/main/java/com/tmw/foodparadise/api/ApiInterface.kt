package com.tmw.foodparadise.api

import com.tmw.foodparadise.model.Category
import com.tmw.foodparadise.model.Random
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("categories.php")
    fun getCategory(
        @Query("categories.php")categories:String
    ): Call<Category>
}
