package com.wf.nbalivestats

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wf.nbalivestats.adapter.TeamNameAdapter

class ActivityNbaTeams : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nba_teams)

            val rV_teams = findViewById<RecyclerView>(R.id.rv_teams)
            rV_teams.setHasFixedSize(true)

            // Creating an instance of our NameAdapter class and setting it to our RecyclerView
            val teamNameList = getListOfTeamNames()
            val TeamNamesAdapter = TeamNameAdapter(teamNameList)
            rV_teams.adapter = TeamNamesAdapter
            // Setting our RecyclerView's layout manager equal to LinearLayoutManager
            rV_teams.layoutManager = LinearLayoutManager(this)
        }
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