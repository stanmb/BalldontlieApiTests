package teams

import common.BalldontlieApi
import io.qameta.allure.kotlin.Allure.step
import io.qameta.allure.kotlin.Feature
import io.qameta.allure.kotlin.junit4.AllureRunner
import io.qameta.allure.kotlin.junit4.DisplayName
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals

import org.junit.runner.RunWith
import kotlin.test.Test
import kotlin.test.assertNotNull

@RunWith(AllureRunner::class)
class BalldontlieApiTest {

    @Test
    @DisplayName("Fetch all teams from v1/teams")
    @Feature("Teams")
    fun `test teams API returns 45 teams`() {
        lateinit var teams: List<Team>
        step("Fetch teams from v1/teams") {
            teams = runBlocking {
                BalldontlieApi.teamsApiService.getTeams().data
            }
        }
        step("Assert team size equals 45") {
            assertEquals(45, teams.size)
        }
    }

    @Test
    @DisplayName("Assert all fields of team object are filled")
    fun `test fields of team object`() {
        lateinit var teams: List<Team>
        step("Fetch teams from v1/teams") {
            teams = runBlocking {
                BalldontlieApi.teamsApiService.getTeams().data
            }
        }
        val firstTeam = teams.first()
        step("Assert that team object has name") {
            assertNotNull(firstTeam.name)
        }
        step("Assert that team object has id") {
            assertNotNull(firstTeam.id)
        }
        step("Assert that team object has fullName") {
            assertNotNull(firstTeam.fullName)
        }
        step("Assert that team object has city") {
            assertNotNull(firstTeam.city)
        }
        step("Assert that team object has city") {
            assertNotNull(firstTeam.division)
        }
        step("Assert that team object has abbreviation") {
            assertNotNull(firstTeam.abbreviation)
        }
        step("Assert that team object has conference") {
            assertNotNull(firstTeam.conference)
        }
    }

    @Test
    @DisplayName("Assert endpoint retrieves a specific team")
    fun testGetConcreteTeam() {
        val expectedTeam = Team(
            id = 1,
            conference = "East",
            division = "Southeast",
            city = "Atlanta",
            name = "Hawks",
            fullName = "Atlanta Hawks",
            abbreviation = "ATL"
        )
        lateinit var team: Team
        step("Fetch the team with id 1 from v1/teams/{id}") {
            team = runBlocking {
                BalldontlieApi.teamsApiService.getTeam(1).data
            }
        }
        step("Assert we got correct team") {
            assertEquals(expectedTeam, team)
        }
    }
}
