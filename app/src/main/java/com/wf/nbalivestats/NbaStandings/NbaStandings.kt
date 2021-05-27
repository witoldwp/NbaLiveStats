package com.wf.nbalivestats.NbaStandings

import android.telecom.Conference

data class NbaStandings(

    val errors: List<Any>,
    val `get`: String,
    val parameters: Parameters,
    val response: List<List<Response>>,
    val results: Int
)

data class Parameters(
    val league: String,
    val season: String
)

data class Response(
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

data class Country(
    val code: String,
    val flag: String,
    val id: Int,
    val name: String
)

data class Games(
    val lose: Lose,
    val played: Int,
    val win: Win
)

data class Group(
    val name: String,
    val points: Any
)

data class League(
    val id: Int,
    val logo: String,
    val name: String,
    val season: String,
    val type: String
)

data class Points(
    val against: Int,
    val `for`: Int
)

data class Team(
    val id: Int,
    val logo: String,
    val name: String
)

data class Lose(
    val percentage: String,
    val total: Int
)

data class Win(
    val percentage: String,
    val total: Int
)