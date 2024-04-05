package common

import players.PlayersApiService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import teams.TeamsApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


object BalldontlieApi {
    private val logger = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BASIC
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(logger)
        .build()


    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(okHttpClient)
        .build()

    val teamsApiService: TeamsApiService = retrofit.create(TeamsApiService::class.java)
    val playerApiService: PlayersApiService = retrofit.create(PlayersApiService::class.java)
}