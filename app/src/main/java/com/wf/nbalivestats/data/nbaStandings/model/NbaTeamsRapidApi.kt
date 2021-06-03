 package com.wf.nbalivestats.data.nbaStandings.model

 import com.wf.nbalivestats.data.nbaStandings.model.ParametersTeams
 import com.wf.nbalivestats.data.nbaStandings.model.ResponseTeams

 data class NbaTeamsRapidApi(
     val errors: List<Any>,
     val `get`: String,
     val parameters: ParametersTeams,
     val response: List<ResponseTeams>,
     val results: Int
)