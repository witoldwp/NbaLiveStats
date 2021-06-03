package com.wf.nbalivestats.features.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.wf.nbalivestats.features.NbaPlayers.ActivityNbaPlayers
import com.wf.nbalivestats.nbaStandings.ActivityNbaStandings
import com.wf.nbalivestats.NbaTeams.NbaTeamsActivity
import com.wf.nbalivestats.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Przejście do ActivityNbaTeams
        val btnTeamActivityNbaTeams = findViewById<Button>(R.id.id_btn_teams)
        btnTeamActivityNbaTeams.setOnClickListener {
            val intent = Intent(this, NbaTeamsActivity::class.java)
            startActivity(intent)
        }
        //Przejście do ActivityNbaPlayers
        val btnTeamActivityNbaPlayers = findViewById<Button>(R.id.id_btn_players)
        btnTeamActivityNbaPlayers.setOnClickListener {
            val intent = Intent(this, ActivityNbaPlayers::class.java)
            startActivity(intent)
        }
        //Przejście do ActivityNbaGames
        val btnTeamActivityNbaGames = findViewById<Button>(R.id.id_btn_standings)
        btnTeamActivityNbaGames.setOnClickListener {
            val intent = Intent(this, ActivityNbaStandings::class.java)
            startActivity(intent)
        }
    }
}

