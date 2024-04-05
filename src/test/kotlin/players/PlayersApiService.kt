package players

import common.API_KEY
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface PlayersApiService {
    @Headers("Authorization: $API_KEY")
    @GET("v1/players")
    suspend fun getPlayers(
        @Query("per_page") perPage: Int? = null,
        @Query("first_name") firstName: String? = null
    ): PlayerResponse

    @Headers("Authorization: $API_KEY")
    @GET("v1/players/{id}")
    suspend fun getPlayer(@Path("id") id: Int): PlayerByIdResponse
}


