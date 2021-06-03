package com.wf.nbalivestats.nbaStandings.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wf.nbalivestats.nbaStandings.ItemListStandings
import com.wf.nbalivestats.nbaStandings.ViewHolderStandingsHeader
import com.wf.nbalivestats.R

class HeaderAdapter(private val header: MutableList<ItemListStandings>) :
    RecyclerView.Adapter<ViewHolderStandingsHeader>() {

    private lateinit var recyclerViewHeaders: RecyclerView
    var listOfItems: MutableList<ItemListStandings>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderStandingsHeader {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_header, parent, false)
        return ViewHolderStandingsHeader(view)
        val nbaStandingListAdapter = NbaListAdapter(listOfItems?: mutableListOf())
        recyclerViewHeaders.adapter = nbaStandingListAdapter
        initView()
    }

    override fun onBindViewHolder(holder: ViewHolderStandingsHeader, position: Int) {
        val element = header[position]
        holder.idHeader.text = element.nameKey
    }

    override fun getItemCount(): Int {
        return header.size
    }
    private fun initView(){
        recyclerViewHeaders = findViewById(R.id.rv_header)
        recyclerViewHeaders.setHasFixedSize(true)
        recyclerViewHeaders.layoutManager = LinearLayoutManager(this)
    }
}