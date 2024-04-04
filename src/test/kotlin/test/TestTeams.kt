package test

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals

import org.junit.jupiter.api.Test


class TeamsApiTest {

    @Test
    fun `test teams API request`() {
        val apiKey = "d287910c-e58c-4b62-b936-d585eafa9b40"
        val teams = runBlocking {
            TeamsApi.service.getTeams(apiKey).data
        }

        assertEquals(45, teams.size)

        assertEquals(1, teams[0].id)
        assertEquals("East", teams[0].conference)
        assertEquals("Southeast", teams[0].division)
        assertEquals("Atlanta", teams[0].city)
        assertEquals("Hawks", teams[0].name)
        assertEquals("Atlanta Hawks", teams[0].fullName)
        assertEquals("ATL", teams[0].abbreviation)
    }
}