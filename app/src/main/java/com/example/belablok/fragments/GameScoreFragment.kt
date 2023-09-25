package com.example.belablok.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.belablok.GameScoreViewModel
import com.example.belablok.OnBtnClickListener
import com.example.belablok.RVAdapterListener
import com.example.belablok.adapters.MiViScoreAdapter
import com.example.belablok.databinding.FragmentGameScoreBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class GameScoreFragment() : Fragment(),RVAdapterListener  {
    private lateinit var binding: FragmentGameScoreBinding
    private lateinit var calculatorFragmentTransaction: OnBtnClickListener
    private val gameScoreViewModel: GameScoreViewModel by activityViewModels()
    private lateinit var rvAdapter: MiViScoreAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameScoreBinding.inflate(layoutInflater)
        return binding.root
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
         rvAdapter = MiViScoreAdapter(childFragmentManager)

        rvAdapter.updateScoreListItems(gameScoreViewModel.scoreList)

        binding.gameScoresRV.adapter = rvAdapter

        binding.newEntryButton.setOnClickListener {
            calculatorFragmentTransaction.onNewEntryBtnClick()
        }
    }

    override fun provideMiViScoreAdapter(): MiViScoreAdapter {
        return rvAdapter
    }

}







