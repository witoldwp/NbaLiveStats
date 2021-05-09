package com.wf.nbalivestats

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.i
import android.widget.Button
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Przejście do ActivityNbaTeams
        val btnTeamActivityNbaTeams = findViewById<Button>(R.id.id_btn_teams)
        btnTeamActivityNbaTeams.setOnClickListener {
            val intent = Intent(this,ActivityNbaTeams::class.java)
            startActivity(intent)
//            setContentView(R.layout.activity_nba_teams)
        }

        //Przejście do ActivityNbaPlayers
        val btnTeamActivityNbaPlayers = findViewById<Button>(R.id.id_btn_players)
        btnTeamActivityNbaPlayers.setOnClickListener {
            val intent = Intent(this,ActivityNbaPlayers::class.java)
            startActivity(intent)
//            setContentView(R.layout.activity_nba_players)
        }
        //Przejście do ActivityNbaGames
        val btnTeamActivityNbaGames = findViewById<Button>(R.id.id_btn_games)
        btnTeamActivityNbaGames.setOnClickListener {
            val intent = Intent(this,ActivityNbaGames::class.java)
            startActivity(intent)
        }

        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        call.enqueue(object : Callback<NbaTeams> {
            override fun onResponse(call: Call<NbaTeams>, response: Response<NbaTeams>) {
                if (response.code() == 200) {
                    response.body()?.data?.forEach {
                        i("TEST", "Team: ${it.fullName}")
                    }
                }
            }

            override fun onFailure(call: Call<NbaTeams>, t: Throwable) {
                i("test", "failure")
            }
        }
        )
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

