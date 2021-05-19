package com.wf.nbalivestats

import android.os.Bundle
import android.util.Log
import android.util.Log.i
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wf.nbalivestats.adapter.NbaStandingsAdapter
import com.wf.nbalivestats.databinding.ActivityNbaStandingsBinding
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.w3c.dom.Element
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ActivityNbaStandings : AppCompatActivity() {

    private lateinit var binding: ActivityNbaStandingsBinding
    private lateinit var recyclerViewStandings : RecyclerView
    private val logging = HttpLoggingInterceptor()
    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api-nba-v1.p.rapidapi.com/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val service: RapidApiBasketball = retrofit.create(RapidApiBasketball::class.java)
    val call = service.getNbaStandings(12, "2020-2021")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNbaStandingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val recyclerViewNbaStandings = findViewById<RecyclerView>(R.id.rv_standings)
        val pbar = findViewById<ProgressBar>(R.id.pB_id)
        recyclerViewNbaStandings.setHasFixedSize(true)

        call.enqueue(object : Callback<TestPlugin> {
            override fun onResponse(call: Call<TestPlugin>, response: Response<TestPlugin>) {
                if (response.isSuccessful) {
                    val standings = response.body()?.response?.get(0) ?: listOf()
                    val nbaStandingsAdapter = NbaStandingsAdapter(standings)
                    recyclerViewNbaStandings.adapter = nbaStandingsAdapter
                    pbar.visibility = View.GONE
                }
            }
            override fun onFailure(call: Call<TestPlugin>, t: Throwable) {
                t.printStackTrace()
            }
        })
        recyclerViewNbaStandings.layoutManager = LinearLayoutManager(this)
    }
    private fun initView(){
        recyclerViewStandings = findViewById(R.id.rv_standings)
        recyclerViewStandings.setHasFixedSize(true)
        recyclerViewStandings.layoutManager = LinearLayoutManager(this)
    }


}