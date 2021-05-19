package com.wf.nbalivestats

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NbaStatsBallDontLie {
    @GET("api/v1/teams")
    fun getAllTeams( @Query("page") page: Int, @Query("per_page") per_page: Int ): Call<NbaTeams>


    @GET("api/v1/players")
    fun getAllPlayers( @Query("page") page: Int, @Query("per_page") per_page: Int,@Query("search") search: String = "",): Call<NbaPlayers>
}

interface RapidApiBasketball{
//    @GET("standings/12/2021")
    @GET("standings")
    @Headers(value = ["x-rapidapi-key: 52a74a3cb5mshd973002475f2c78p159337jsn72bac449aefe","x-rapidapi-host: api-basketball.p.rapidapi.com"])
    fun getNbaStandings(@Query("league") league: Int, @Query("season") season: String) : Call<TestPlugin>
}