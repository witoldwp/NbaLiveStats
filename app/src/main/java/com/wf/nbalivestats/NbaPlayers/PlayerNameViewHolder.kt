package com.wf.nbalivestats.NbaPlayers

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.wf.nbalivestats.R

class PlayerNameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val info_player_id = itemView.findViewById(R.id.info_player_id) as TextView
    val info_player_firstName = itemView.findViewById(R.id.info_player_firstName) as TextView
    val info_player_lastName = itemView.findViewById(R.id.info_player_lastName) as TextView
    val info_player_position = itemView.findViewById(R.id.info_player_position) as TextView
    val info_player_team = itemView.findViewById(R.id.info_player_team) as TextView
    val cl_id_to_color = itemView.findViewById(R.id.cl_id_teamDetails_to_color) as ConstraintLayout
}
