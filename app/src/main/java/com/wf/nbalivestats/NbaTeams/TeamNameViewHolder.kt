package com.wf.nbalivestats.NbaTeams

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.wf.nbalivestats.R

class TeamNameViewHolder(item_team_details: View) : RecyclerView.ViewHolder(item_team_details) {
    val info_team_id = itemView.findViewById(R.id.info_team_id) as TextView
    val info_team_abbreviation = itemView.findViewById(R.id.info_team_abbreviation) as TextView
    val info_team_city = itemView.findViewById(R.id.info_team_city) as TextView
    val info_team_conference = itemView.findViewById(R.id.info_team_conference) as TextView
    val info_team_division = itemView.findViewById(R.id.info_team_division) as TextView
    val info_team_fullName = itemView.findViewById(R.id.info_team_fullName) as TextView
    val cl_container_color = itemView.findViewById(R.id.cl_id_teamDetails_to_color) as ConstraintLayout
}
