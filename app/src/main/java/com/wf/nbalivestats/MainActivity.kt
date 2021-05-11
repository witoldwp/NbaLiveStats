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
        }
        //Przejście do ActivityNbaPlayers
        val btnTeamActivityNbaPlayers = findViewById<Button>(R.id.id_btn_players)
        btnTeamActivityNbaPlayers.setOnClickListener {
            val intent = Intent(this,ActivityNbaPlayers::class.java)
            startActivity(intent)
        }
        //Przejście do ActivityNbaGames
        val btnTeamActivityNbaGames = findViewById<Button>(R.id.id_btn_games)
        btnTeamActivityNbaGames.setOnClickListener {
            val intent = Intent(this,ActivityNbaGames::class.java)
            startActivity(intent)
        }
    }
}

