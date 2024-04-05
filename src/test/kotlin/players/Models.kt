package players

import com.squareup.moshi.Json
import teams.Team

data class PlayerResponse(
    val data: List<Player>,
    val meta: Meta
)

data class PlayerByIdResponse(
    val data: Player,
    val meta: Meta
)

data class Player(
    val id: Int,
    @field:Json(name = "first_name") val firstName: String,
    @field:Json(name = "last_name") val lastName: String,
    val position: String,
    val height: String,
    val weight: String,
    @field:Json(name = "jersey_number") val jerseyNumber: String,
    val college: String,
    val country: String,
    @field:Json(name = "draft_year") val draftYear: Int?,
    @field:Json(name = "draft_round") val draftRound: Int?,
    @field:Json(name = "draft_number") val draftNumber: Int?,
    val team: Team
)

data class Meta(
    @field:Json(name = "next_cursor") val nextCursor: Int,
    @field:Json(name = "per_page") val perPage: Int
)