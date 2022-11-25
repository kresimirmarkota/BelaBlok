package com.example.belablok.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.belablok.MainActivity
import com.example.belablok.OnBtnClickListener
import com.example.belablok.adapters.MiViScoreAdapter
import com.example.belablok.R
import com.example.belablok.databinding.FragmentGameScoreBinding

class GameScoreFragment : Fragment() {
    lateinit var binding: FragmentGameScoreBinding
    lateinit var calculatorFragmentTransaction: OnBtnClickListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGameScoreBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnBtnClickListener) {
            calculatorFragmentTransaction = context
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.gameScoresRV.layoutManager = LinearLayoutManager(context)
        val rvAdapter = MiViScoreAdapter()
        binding.gameScoresRV.adapter = rvAdapter

        binding.newEntryButton.setOnClickListener {
            calculatorFragmentTransaction.onNewEntryBtnClick()
        }

    }

}