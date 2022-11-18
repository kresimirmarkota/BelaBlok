package com.example.belablok.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.belablok.adapters.MiViScoreAdapter
import com.example.belablok.R

class GameScoreFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var mitv: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game_score, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.gameScoresRV)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val rvAdapter = MiViScoreAdapter()
        recyclerView.adapter = rvAdapter

    }

    companion object {
        fun newInstance(): GameScoreFragment {
            return GameScoreFragment()
        }
    }
}