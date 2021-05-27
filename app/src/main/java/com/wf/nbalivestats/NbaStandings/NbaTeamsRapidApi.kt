 package com.wf.nbalivestats.NbaStandings

data class NbaTeamsRapidApi(
    val errors: List<Any>,
    val `get`: String,
    val parameters: ParametersTeams,
    val response: List<ResponseTeams>,
    val results: Int
)

data class ParametersTeams(
    val league: String,
    val season: String
)

data class ResponseTeams(
    val country: Country,
    val id: Int,
    val logo: String,
    val name: String,
    val nationnal: Boolean
)