package teams

import common.API_KEY
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path


interface TeamsApiService {
    @Headers("Authorization: $API_KEY")
    @GET("v1/teams")
    suspend fun getTeams(): TeamsResponse

    @Headers("Authorization: $API_KEY")
    @GET("v1/teams/{id}")
    suspend fun getTeam(@Path("id") id: Int): TeamByIDResponse
}