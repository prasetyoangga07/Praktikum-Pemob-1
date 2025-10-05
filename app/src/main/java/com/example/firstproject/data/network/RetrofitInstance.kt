package com.example.firstproject.data.network

import com.example.firstproject.utils.Constants
import com.example.firstproject.data.network.OpenLibraryApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: OpenLibraryApi by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OpenLibraryApi::class.java)

    }
}
