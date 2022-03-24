package com.generation.todo.api

import com.generation.todo.util.Constantis
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constantis.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build() }

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java) }
}