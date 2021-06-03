package com.wf.nbalivestats.data.nbaStandings.model

data class ResponseTeams(
    val country: Country,
    val id: Int,
    val logo: String,
    val name: String,
    val nationnal: Boolean
)