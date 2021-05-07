package com.wf.nbalivestats

import com.google.gson.annotations.SerializedName

class NbaTeams(
    val data: List<NbaTeam>
)

class NbaTeam(
    val id: Int,
    val abbreviation: String,
    val city: String,
    val conference: String,
    val division: String,
    @SerializedName("full_name") val fullName: String,
    val name: String
)