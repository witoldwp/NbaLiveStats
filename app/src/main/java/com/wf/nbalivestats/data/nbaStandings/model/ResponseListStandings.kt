package com.wf.nbalivestats.data.nbaStandings.model

data class ResponseListStandings(
    val country: Country,
    val description: String,
    val form: String,
    val games: Games,
    val group: Group,
    val league: League,
    val points: Points,
    val position: Int,
    val stage: String,
    val team: Team
)