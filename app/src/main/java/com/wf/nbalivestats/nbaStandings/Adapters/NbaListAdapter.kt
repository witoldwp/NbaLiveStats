package com.wf.nbalivestats.nbaStandings.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wf.nbalivestats.nbaStandings.ViewHolderStandingTeams
import com.wf.nbalivestats.data.nbaStandings.model.ResponseListStandings
import com.wf.nbalivestats.R

class NbaListAdapter(private val nbaStandingList: MutableList<ResponseListStandings>) :
    RecyclerView.Adapter<ViewHolderStandingTeams>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderStandingTeams {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_nba_standings_details, parent, false)
        return ViewHolderStandingTeams(view)
    }

    override fun onBindViewHolder(holder: ViewHolderStandingTeams, position: Int) {
        nbaStandingList?.get(position)?.let {
            holder.team_abbreviation.text = it.team.name
            holder.league_position.text = it.position.toString()
            Glide.with(holder.team_logo.context)
                .load(it.team.logo)
                .into(holder.team_logo)
            holder.win_number.text = it.games.win.total.toString()
            holder.lose_number.text = it.games.lose.total.toString()
            holder.winRR.text = it.games.win.percentage
            holder.last10_number.text = it.form
        }
    }

    override fun getItemCount(): Int {
        return nbaStandingList.size
    }
}