package com.wf.nbalivestats

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wf.nbalivestats.databinding.ActivityNbaStandingsBinding


class ActivityNbaStandings : AppCompatActivity() {

    private lateinit var binding: ActivityNbaStandingsBinding
    private lateinit var recyclerViewStandings : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNbaStandingsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }
    private fun initView(){
        recyclerViewStandings = findViewById(R.id.rv_standings)
        recyclerViewStandings.setHasFixedSize(true)
        recyclerViewStandings.layoutManager = LinearLayoutManager(this)
    }
}