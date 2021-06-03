package com.wf.nbalivestats.data.nbaStandings.model

import com.google.gson.annotations.SerializedName
import com.wf.nbalivestats.data.nbaStandings.model.Parameters
import com.wf.nbalivestats.data.nbaStandings.model.ResponseListStandings

data class NbaStandings(
    val errors: List<Any>,
    val `get`: String,
    val parameters: Parameters,
    @SerializedName("response") val responseListStandings: List<List<ResponseListStandings>>,
    val results: Int
)