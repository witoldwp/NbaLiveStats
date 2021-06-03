package com.wf.nbalivestats.data.nbaStandings.api

import com.wf.nbalivestats.data.NbaPlayers.model.NbaPlayers
import com.wf.nbalivestats.NbaTeams.NbaTeams
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NbaStatsBallDontLie {
    @GET("api/v1/teams")
    fun getAllTeams( @Query("page") page: Int, @Query("per_page") per_page: Int ): Call<NbaTeams>


    @GET("api/v1/players")
    fun getAllPlayers( @Query("page") page: Int, @Query("per_page") per_page: Int,@Query("search") search: String = "",): Call<NbaPlayers>
}

