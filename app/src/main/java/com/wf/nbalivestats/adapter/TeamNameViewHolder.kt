package com.wf.nbalivestats.adapter

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wf.nbalivestats.ActivityNbaGames
import com.wf.nbalivestats.ActivityNbaPlayers
import com.wf.nbalivestats.ActivityNbaTeams
import com.wf.nbalivestats.R

class TeamNameViewHolder(item_team_details: View) : RecyclerView.ViewHolder(item_team_details) {
    val info_team_id = item_team_details.findViewById(R.id.info_team_id) as TextView
}