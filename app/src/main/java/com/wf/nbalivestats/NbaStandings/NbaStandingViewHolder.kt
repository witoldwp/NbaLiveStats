package com.wf.nbalivestats.NbaStandings

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wf.nbalivestats.R

class NbaStandingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val league_position = itemView.findViewById(R.id.league_position) as TextView
    val team_abbreviation = itemView.findViewById(R.id.team_abbreviation) as TextView
    val win_number = itemView.findViewById(R.id.win_number) as TextView
    val lose_number = itemView.findViewById(R.id.lose_number) as TextView
    val team_logo = itemView.findViewById(R.id.team_logo) as ImageView
    val winRR = itemView.findViewById(R.id.winRR) as TextView
    val last10_number = itemView.findViewById(R.id.last10_number) as TextView
}