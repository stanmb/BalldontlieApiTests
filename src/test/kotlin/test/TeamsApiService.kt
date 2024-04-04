package test

import retrofit2.http.GET
import retrofit2.http.Header


interface TeamsApiService {
    @GET("v1/teams")
    suspend fun getTeams(@Header("Authorization") apiKey: String): TeamsResponse
}