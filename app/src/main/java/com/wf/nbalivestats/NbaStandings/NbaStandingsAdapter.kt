package com.wf.nbalivestats.NbaStandings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wf.nbalivestats.R

class NbaStandingsAdapter(private val nbaStandings: List<Response>) :
    RecyclerView.Adapter<NbaStandingViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NbaStandingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_nba_standings_details, parent, false)
        return NbaStandingViewHolder(view)
    }

    override fun onBindViewHolder(holder: NbaStandingViewHolder, position: Int) {
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
}