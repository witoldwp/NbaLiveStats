package com.wf.nbalivestats.nbaStandings

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wf.nbalivestats.R

class ViewHolderStandingsHeader(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val idHeader = itemView.findViewById(R.id.id_header) as TextView
}