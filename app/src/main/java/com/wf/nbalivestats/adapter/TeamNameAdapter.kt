package com.wf.nbalivestats.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wf.nbalivestats.R



class TeamNameAdapter(private val TeamNames: List<String>) :
    RecyclerView.Adapter<TeamNameAdapter.TeamNameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamNameViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_team_details, parent, false)
        return TeamNameViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamNameViewHolder, position: Int) {
        val element = TeamNames[position]
        holder.info_team_id.text = element
    }

    override fun getItemCount(): Int {
        return TeamNames.size
    }

    class TeamNameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val info_team_id = itemView.findViewById(R.id.info_team_id) as TextView
    }
}