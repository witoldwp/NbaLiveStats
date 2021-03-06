package com.wf.nbalivestats.NbaTeams

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.wf.nbalivestats.R

class NbaTeamNameAdapter(private val teamNames: List<NbaSpecificTeam>) :
    RecyclerView.Adapter<TeamNameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamNameViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_team_details, parent, false)
        return TeamNameViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamNameViewHolder, position: Int) {
        val element = teamNames[position]
        holder.info_team_id.text = element.id.toString()
        holder.info_team_abbreviation.text = element.abbreviation
        holder.info_team_city.text = element.city
        holder.info_team_conference.text = element.conference
        holder.info_team_division.text = element.division
        holder.info_team_fullName.text = element.fullName

        //background color on the list of teams
        val isElementEven = position.rem(2) == 0
        if (isElementEven) {
            holder.cl_container_color.setBackgroundColor(
                ContextCompat.getColor(
                    holder.cl_container_color.context,
                    R.color.blueNY_t00
                )
            )
        } else {
            holder.cl_container_color.setBackgroundColor(
                ContextCompat.getColor(
                    holder.cl_container_color.context,
                    R.color.blueNY_t50
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return teamNames.size
    }

//    class TeamNameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val info_team_id = itemView.findViewById(R.id.info_team_id) as TextView
//        val info_team_abbreviation = itemView.findViewById(R.id.info_team_abbreviation) as TextView
//        val info_team_city = itemView.findViewById(R.id.info_team_city) as TextView
//        val info_team_conference = itemView.findViewById(R.id.info_team_conference) as TextView
//        val info_team_division = itemView.findViewById(R.id.info_team_division) as TextView
//        val info_team_fullName = itemView.findViewById(R.id.info_team_fullName) as TextView
//        val cl_container_color = itemView.findViewById(R.id.cl_id_teamDetails_to_color) as ConstraintLayout
//    }
}