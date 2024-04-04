package test

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object TeamsApi {
    private const val BASE_URL = "https://api.balldontlie.io/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val service: TeamsApiService = retrofit.create(TeamsApiService::class.java)
}