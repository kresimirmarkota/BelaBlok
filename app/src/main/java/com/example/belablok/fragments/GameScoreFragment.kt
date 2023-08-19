package com.example.belablok.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.belablok.GameScoreViewModel
import com.example.belablok.OnBtnClickListener
import com.example.belablok.adapters.MiViScoreAdapter
import com.example.belablok.databinding.FragmentGameScoreBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class GameScoreFragment : Fragment() {
    private lateinit var binding: FragmentGameScoreBinding
    private lateinit var calculatorFragmentTransaction: OnBtnClickListener
    private val gameScoreViewModel: GameScoreViewModel by activityViewModels()


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

        viewLifecycleOwner.lifecycleScope.launch {
            gameScoreViewModel.miViScoresList.collectLatest {
                gameScoreViewModel.scoreMeList.add(it.miScore.toInt())
                gameScoreViewModel.scoreYouList.add(it.viScore.toInt())
                gameScoreViewModel.callMeList.add(it.miCall.toInt())
                gameScoreViewModel.callYouList.add(it.viCall.toInt())
                binding.totalMiScore.text = gameScoreViewModel.scoreMeList.sum().toString()
                binding.totalViScore.text = gameScoreViewModel.scoreYouList.sum().toString()
                binding.totalMiCall.text = gameScoreViewModel.callMeList.sum().toString()
                binding.totalViCall.text = gameScoreViewModel.callYouList.sum().toString()
            }

        }

        binding.gameScoresRV.layoutManager = LinearLayoutManager(context)
        val rvAdapter = MiViScoreAdapter(childFragmentManager)

        rvAdapter.updateScoreList(gameScoreViewModel.getPopulatedMiViScoreList())
        binding.gameScoresRV.adapter = rvAdapter

        binding.newEntryButton.setOnClickListener {
            calculatorFragmentTransaction.onNewEntryBtnClick()
        }
    }


}







