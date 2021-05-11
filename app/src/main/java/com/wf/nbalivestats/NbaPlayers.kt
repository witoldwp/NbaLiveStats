package com.wf.nbalivestats

import com.google.gson.annotations.SerializedName

class NbaPlayers(
    val data: List<NbaSpecificPlayer>
)

class NbaSpecificPlayer(
    val id: Int,
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    val position: String,
    @SerializedName("height_feet") val heightFeet: Int,
    @SerializedName("height_inch") val heightInch: Int,
    @SerializedName("weight_pounds") val weightPounds: Int,
    val team: NbaSpecificTeam
)