package com.wf.nbalivestats.NbaTeams

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wf.nbalivestats.R

class TeamNameViewHolder(item_team_details: View) : RecyclerView.ViewHolder(item_team_details) {
    val info_team_id = item_team_details.findViewById(R.id.info_player_id) as TextView
}
