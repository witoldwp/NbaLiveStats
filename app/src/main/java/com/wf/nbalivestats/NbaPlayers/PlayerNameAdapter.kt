package com.wf.nbalivestats.NbaPlayers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.wf.nbalivestats.R

class PlayerNameAdapter(private val playerNames: List<NbaSpecificPlayer>) :
    RecyclerView.Adapter<PlayerNameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerNameViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_player_details, parent, false)
        return PlayerNameViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerNameViewHolder, position: Int) {
        val element = playerNames[position]
        holder.info_player_id.text = element.id.toString()
        holder.info_player_firstName.text = element.firstName
        holder.info_player_lastName.text = element.lastName
        holder.info_player_position.text = element.position
        holder.info_player_team.text = element.team.fullName

        //background color on the list of players
        val isElementEven = position.rem(2) == 0
        if (isElementEven) {
            holder.cl_id_to_color.setBackgroundColor(
                ContextCompat.getColor(
                    holder.cl_id_to_color.context,
                    R.color.blueNY_t00
                )
            )
        } else {
            holder.cl_id_to_color.setBackgroundColor(
                ContextCompat.getColor(
                    holder.cl_id_to_color.context,
                    R.color.blueNY_t50
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return playerNames.size
    }
}