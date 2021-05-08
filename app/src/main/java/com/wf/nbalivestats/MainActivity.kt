package com.wf.nbalivestats

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.i
import android.widget.Button
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

class MainActivity : AppCompatActivity() {

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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rV_teams = findViewById<RecyclerView>(R.id.rv_teams)


        // Creating an instance of our NameAdapter class and setting it to our RecyclerView
        val teamNameList = getListOfTeamNames()
        val TeamNamesAdapter = TeamNameAdapter(teamNameList)
        rV_teams.adapter = TeamNamesAdapter
        // Setting our RecyclerView's layout manager equal to LinearLayoutManager
        rV_teams.layoutManager = LinearLayoutManager(this)


        //NewActivity launcher "ActivityNbaTeams"
        val id_btn_teams = findViewById<Button>(R.id.id_btn_teams)
        id_btn_teams.setOnClickListener {
            val intent = Intent(this, ActivityNbaTeams::class.java)
            // start your next activity
            startActivity(intent)
        }

        //NewActivity launcher "ActivityNbaPlayers"
        val id_btn_players = findViewById<Button>(R.id.id_btn_players)
        id_btn_players.setOnClickListener {
            val intent = Intent(this, ActivityNbaPlayers::class.java)
            // start your next activity
            startActivity(intent)
        }

        //NewActivity launcher "ActivityNbaGames"
        val id_btn_games = findViewById<Button>(R.id.id_btn_games)
        id_btn_games.setOnClickListener {
            val intent = Intent(this, ActivityNbaGames::class.java)
            // start your next activity
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

    // This function just creates a list of names for us
    private fun getListOfTeamNames(): MutableList<String> {
        val teamNameList = mutableListOf<String>()
        teamNameList.add("Ali")
        teamNameList.add("Sophia")
        teamNameList.add("Isabella")
        teamNameList.add("Mason")
        teamNameList.add("Jacob")
        teamNameList.add("William")
        teamNameList.add("Olivia")
        return teamNameList
    }
}

