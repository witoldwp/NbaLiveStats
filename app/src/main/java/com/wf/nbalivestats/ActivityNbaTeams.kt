package com.wf.nbalivestats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wf.nbalivestats.adapter.TeamNameAdapter
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ActivityNbaTeams : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nba_teams)

        val recyclerViewTeams = findViewById<RecyclerView>(R.id.rv_teams)
        recyclerViewTeams.setHasFixedSize(true)

        val Pbar = findViewById<ProgressBar>(R.id.pB_id)

        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        call.enqueue(object : Callback<NbaTeams> {
            override fun onResponse(call: Call<NbaTeams>, response: Response<NbaTeams>) {
                if (response.isSuccessful) {
                    val teams = response.body()?.data ?: listOf()
                    val teamNamesAdapter = TeamNameAdapter(teams)
                    recyclerViewTeams.adapter = teamNamesAdapter
                    Pbar.setVisibility(View.GONE)

                }
            }

            override fun onFailure(call: Call<NbaTeams>, t: Throwable) {
                Log.i("test", "failure")
            }
        })
        recyclerViewTeams.layoutManager = LinearLayoutManager(this)
    }

    val logging = HttpLoggingInterceptor()
    val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://www.balldontlie.io/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(NbaStatsBallDontLie::class.java)
    val call = service.getAllTeams(0, 30)
}