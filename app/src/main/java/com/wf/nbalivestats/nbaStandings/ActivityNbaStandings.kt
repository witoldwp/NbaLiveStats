package com.wf.nbalivestats.nbaStandings

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wf.nbalivestats.nbaStandings.Adapters.HeaderAdapter
import com.wf.nbalivestats.data.nbaStandings.model.NbaStandings
import com.wf.nbalivestats.data.nbaStandings.model.ResponseListStandings
import com.wf.nbalivestats.R
import com.wf.nbalivestats.RapidApiBasketball
import com.wf.nbalivestats.databinding.ActivityNbaStandingsBinding
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ActivityNbaStandings : AppCompatActivity() {

    private lateinit var binding: ActivityNbaStandingsBinding
    private lateinit var recyclerViewStandings: RecyclerView
    private lateinit var recyclerViewHeaders: RecyclerView
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
    private val call = service.getNbaStandings(12, "2020-2021")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNbaStandingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val recyclerViewHeaders = findViewById<RecyclerView>(R.id.rv_header)
        val recyclerViewNbaStandings = findViewById<RecyclerView>(R.id.rv_standings)
        val pbar = findViewById<ProgressBar>(R.id.pB_id)
        recyclerViewNbaStandings.setHasFixedSize(true)

        call.enqueue(object : Callback<NbaStandings> {
            override fun onResponse(call: Call<NbaStandings>, response: Response<NbaStandings>) {
                if (response.isSuccessful) {
                    var listOfItems: MutableList<ItemListStandings>? = null
//                  val standings = response.body()?.response?.get(0)?: listOf()
                    val standings =

                        (response.body()?.responseListStandings?.get(0)?.groupBy { it.group.name })
                    standings?.forEach {
                        val nameKey = it.key
                        val listOfTeamsValue = it.value
                        val singleItemListStandings = ItemListStandings(nameKey, listOfTeamsValue as MutableList<ResponseListStandings>)
                        listOfItems?.add(singleItemListStandings)
                    }
                    val headersAdapter = HeaderAdapter(listOfItems ?: mutableListOf() )
                    recyclerViewNbaStandings.adapter = headersAdapter
                    pbar.visibility = View.GONE
                }
            }

            override fun onFailure(call: Call<NbaStandings>, t: Throwable) {
                t.printStackTrace()
            }
        })
        recyclerViewNbaStandings.layoutManager = LinearLayoutManager(this)
    }

    private fun initView() {
        recyclerViewStandings = findViewById(R.id.rv_standings)
        recyclerViewStandings.setHasFixedSize(true)
        recyclerViewStandings.layoutManager = LinearLayoutManager(this)
    }
}