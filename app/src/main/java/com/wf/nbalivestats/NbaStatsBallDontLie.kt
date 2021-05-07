package com.wf.nbalivestats

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NbaStatsBallDontLie {
    @GET("api/v1/teams")
    fun getAllTeams( @Query("page") page: Int, @Query("per_page") per_page: Int ): Call<NbaTeams>
}