package com.wf.nbalivestats

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.wf.nbalivestats.NbaPlayers.ActivityNbaPlayers
import com.wf.nbalivestats.NbaStandings.ActivityNbaStandings
import com.wf.nbalivestats.NbaTeams.ActivityNbaTeams


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Przejście do ActivityNbaTeams
        val btnTeamActivityNbaTeams = findViewById<Button>(R.id.id_btn_teams)
        btnTeamActivityNbaTeams.setOnClickListener {
            val intent = Intent(this, ActivityNbaTeams::class.java)
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

