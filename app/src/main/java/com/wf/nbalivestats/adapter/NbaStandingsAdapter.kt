package com.wf.nbalivestats.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wf.nbalivestats.TestPlugin
import com.wf.nbalivestats.R
import com.wf.nbalivestats.Response
import com.wf.nbalivestats.Win

class NbaStandingsAdapter(private val nbaStandings: List<Response>) :
    RecyclerView.Adapter<NbaStandingsAdapter.NbaStandingViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NbaStandingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_nba_standings_details, parent, false)
        return NbaStandingViewHolder(view)
    }


    override fun onBindViewHolder(holder: NbaStandingViewHolder,position: Int) {
        val element = nbaStandings[position]
        holder.league_position.text = element.position.toString()
        holder.team_abbreviation.text = element.team.name
        Glide.with(holder.team_logo.context)
            .load(element.team.logo)
            .into(holder.team_logo)
        holder.win_number.text = element.games.win.total.toString()
        holder.lose_number.text = element.games.lose.total.toString()
        holder.winRR.text = element.games.win.percentage
        holder.last10_number.text = element.form



    }

    override fun getItemCount(): Int {
        return nbaStandings.size
    }

    class NbaStandingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val league_position = itemView.findViewById(R.id.league_position) as TextView
        val team_abbreviation = itemView.findViewById(R.id.team_abbreviation) as TextView
        val win_number = itemView.findViewById(R.id.win_number) as TextView
        val lose_number = itemView.findViewById(R.id.lose_number) as TextView
        val team_logo = itemView.findViewById(R.id.team_logo) as ImageView
        val winRR = itemView.findViewById(R.id.winRR) as TextView
        val last10_number = itemView.findViewById(R.id.last10_number) as TextView
    }
}