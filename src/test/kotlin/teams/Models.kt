package teams

import com.squareup.moshi.Json

data class Team(
    val id: Int,
    val conference: String,
    val division: String,
    val city: String,
    val name: String,
    @field:Json(name = "full_name") val fullName: String,
    val abbreviation: String
)

// Model for v1/teams
data class TeamsResponse(
    val data: List<Team>
)

// Model for v1/teams/{id}
data class TeamByIDResponse(
    val data: Team
)