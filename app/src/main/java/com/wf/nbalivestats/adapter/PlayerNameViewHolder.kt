package com.wf.nbalivestats.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wf.nbalivestats.R

class PlayerNameViewHolder(item_team_details: View) : RecyclerView.ViewHolder(item_team_details) {
    val info_player_id = item_team_details.findViewById(R.id.info_team_id) as TextView
}