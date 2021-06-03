package com.wf.nbalivestats.data.nbaStandings.api

import com.wf.nbalivestats.data.nbaStandings.model.NbaStandings
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RapidApiBasketball{
    //    @GET("standings/12/2021")
    @GET("standings")
    @Headers(value = ["x-rapidapi-key: 52a74a3cb5mshd973002475f2c78p159337jsn72bac449aefe","x-rapidapi-host: api-basketball.p.rapidapi.com"])
    fun getNbaStandings(@Query("league") league: Int, @Query("season") season: String) : Call<NbaStandings>
}
