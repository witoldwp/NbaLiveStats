package com.wf.nbalivestats.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.wf.nbalivestats.NbaSpecificPlayer
import com.wf.nbalivestats.R

class PlayerNameAdapter(private val playerNames: List<NbaSpecificPlayer>) :
    RecyclerView.Adapter<PlayerNameAdapter.PlayerNameViewHolder>() {

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
        holder.info_player_heightFeet.text = element.heightFeet.toString()
        holder.info_player_heightInches.text = element.heightInch.toString()
        holder.info_player_weightPounds.text = element.weightPounds.toString()
        holder.info_player_team.text = element.team.toString()

        val isElementEven = position.rem(2) == 0
        if (isElementEven) {
            holder.ll_player_container.setBackgroundColor(
                ContextCompat.getColor(
                    holder.ll_player_container.context,
                    R.color.blueNY_t10
                )
            )
        } else {
            holder.ll_player_container.setBackgroundColor(
                ContextCompat.getColor(
                    holder.ll_player_container.context,
                    R.color.blueNY_t50
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return playerNames.size
    }

    class PlayerNameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val info_player_id = itemView.findViewById(R.id.info_player_id) as TextView
        val info_player_firstName = itemView.findViewById(R.id.info_player_firstName) as TextView
        val info_player_lastName = itemView.findViewById(R.id.info_player_lastName) as TextView
        val info_player_position = itemView.findViewById(R.id.info_player_position) as TextView
        val info_player_heightFeet = itemView.findViewById(R.id.info_player_heightFeet) as TextView
        val info_player_heightInches = itemView.findViewById(R.id.info_player_heightInches) as TextView
        val info_player_weightPounds = itemView.findViewById(R.id.info_player_weightPounds) as TextView
        val info_player_team = itemView.findViewById(R.id.info_player_team) as TextView
        val ll_player_container = itemView.findViewById(R.id.ll_player_container) as LinearLayout
    }
}