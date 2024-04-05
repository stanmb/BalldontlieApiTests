package players

import common.BalldontlieApi
import io.qameta.allure.kotlin.Allure.step
import io.qameta.allure.kotlin.junit4.AllureRunner
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.HttpException
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@RunWith(AllureRunner::class)
class PlayersTests {

    @Test
    fun getAllPlayersWithDefaultNumber() {
        lateinit var players: List<Player>
        step("Get all players") {
            players = runBlocking {
                BalldontlieApi.playerApiService.getPlayers().data
            }
        }
        step("Assert the number of players is 25") {
            assertEquals(25, players.size)
        }
    }

    @Test
    fun get100PlayersOnPage() {
        lateinit var players: List<Player>
        step("Get 100 players") {
            players = runBlocking {
                BalldontlieApi.playerApiService.getPlayers(perPage = 100).data
            }
        }
        step("Assert the number of players is 100") {
            assertEquals(100, players.size)
        }
    }

    @Test
    fun get1PlayerOnPage() {
        lateinit var players: List<Player>
        step("Get 1 player") {
            players = runBlocking {
                BalldontlieApi.playerApiService.getPlayers(perPage = 1).data
            }
        }
        step("Assert the number of players is 1") {
            assertEquals(1, players.size)
        }
    }

    @Test
    fun getDefaultNumberIfParamLessThanZero() {
        lateinit var players: List<Player>
        step("Get page with 0 players") {
            players = runBlocking {
                BalldontlieApi.playerApiService.getPlayers(perPage = 0).data
            }
        }
        step("Assert the number of players is 25") {
            assertEquals(25, players.size)
        }
    }

    @Test
    fun searchPlayersByFirstName() {
        val firstName = "Stephen"
        lateinit var players: List<Player>
        step("Search players with name $firstName") {
            players = runBlocking {
                BalldontlieApi.playerApiService.getPlayers(firstName = firstName).data
            }
        }
        step("Assert all players have name $firstName") {
            players.forEach {
                assertEquals(firstName, it.firstName)
            }
        }
    }

    @Test
    fun getConcretePlayer() {
        val playerId = 1
        lateinit var player: Player
        step("Get concrete player by id = $playerId") {
            player = runBlocking {
                BalldontlieApi.playerApiService.getPlayer(playerId).data
            }
        }
        step("Assert we get player with id = $playerId") {
            assertEquals(playerId, player.id)
        }
    }

    @Test
    fun getNonExistentPlayer() {
        val playerId = -1
        step("Get player with non existent id = $playerId") {
            assertFailsWith(exceptionClass = HttpException::class) {
                runBlocking {
                    BalldontlieApi.playerApiService.getPlayer(playerId).data
                }
            }
        }
    }
}