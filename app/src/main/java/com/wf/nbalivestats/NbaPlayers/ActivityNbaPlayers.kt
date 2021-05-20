package com.wf.nbalivestats.NbaPlayers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wf.nbalivestats.NbaStatsBallDontLie
import com.wf.nbalivestats.R
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ActivityNbaPlayers : AppCompatActivity() {

    private lateinit var pbar : ProgressBar
    private lateinit var recyclerViewPlayers : RecyclerView
    private lateinit var pickPlayer : EditText
    private lateinit var savedName : TextView
    private lateinit var btnFind : Button
    private var pickResult = ""
    private val logging = HttpLoggingInterceptor()
    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://www.balldontlie.io/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val service: NbaStatsBallDontLie = retrofit.create(NbaStatsBallDontLie::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nba_players)
        initView()
        initListeners()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        loadData()
    }

    private fun saveData(){
        val sharedPreferences = getSharedPreferences("sharedPref", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply {
            putString("STRING KEY",pickPlayer.text.toString())
        }.apply()

        Toast.makeText(this,"Data saved",Toast.LENGTH_SHORT).show()
    }

    private fun loadData(){
        val sharedPreferences = getSharedPreferences("sharedPref", MODE_PRIVATE)
        val savedString = sharedPreferences.getString("STRING KEY",null)
        pickPlayer.setText(savedString)
    }

    private fun initView() {
        pickPlayer = findViewById(R.id.et_pick_your_player)
        btnFind = findViewById(R.id.btn_find_your_player)
        pbar = findViewById(R.id.pB_id)
        recyclerViewPlayers = findViewById(R.id.rv_players)
        recyclerViewPlayers.setHasFixedSize(true)
        recyclerViewPlayers.layoutManager = LinearLayoutManager(this)
    }

    private fun initListeners() {
        pickPlayer.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                pickResult = pickPlayer.text.toString()
            }
        })
        btnFind.setOnClickListener {
            callForPlayer()
            saveData()
        }
    }

    private fun callForPlayer() {
        val call = service.getAllPlayers(0, 100, pickResult)

        call.enqueue(object : Callback<NbaPlayers> {
            override fun onResponse(call: Call<NbaPlayers>, response: Response<NbaPlayers>) {
                Log.i(ActivityNbaPlayers::class.java.name, "Request succeeded ${response.message()}")
                if (response.isSuccessful) {
                    val players = response.body()?.data ?: listOf()
                    val playerNamesAdapter = PlayerNameAdapter(players)
                    recyclerViewPlayers.adapter = playerNamesAdapter
                    pbar.visibility = View.GONE

                }
            }

            override fun onFailure(call: Call<NbaPlayers>, t: Throwable) {
                Log.i(ActivityNbaPlayers::class.java.name, "An error has occurred: ${t.message}")
            }
        })
    }
}