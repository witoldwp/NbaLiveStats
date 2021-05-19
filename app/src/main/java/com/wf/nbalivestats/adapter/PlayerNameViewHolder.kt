package com.wf.nbalivestats.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wf.nbalivestats.R

class PlayerNameViewHolder(item_player_details: View) : RecyclerView.ViewHolder(item_player_details) {
    val league_position = item_player_details.findViewById(R.id.info_team_id) as TextView
}
