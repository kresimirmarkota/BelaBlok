package com.example.belablok.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.belablok.GameScoreViewModel
import com.example.belablok.OnBtnClickListener
import com.example.belablok.Scores
import com.example.belablok.adapters.MiViScoreAdapter
import com.example.belablok.databinding.FragmentGameScoreBinding

class GameScoreFragment : Fragment() {

    private lateinit var binding: FragmentGameScoreBinding
    private lateinit var calculatorFragmentTransaction: OnBtnClickListener
    private val gameScoreViewModel: GameScoreViewModel by activityViewModels()
    var totalMiScore: Int = 0
    var totalViScore: Int = 0
    var totalMiCall: Int = 0
    var totalViCall: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val scoreObserver = Observer<Scores> { score: Scores ->
            var totalMeScoreTemp: Int = 0
            totalMeScoreTemp + score.miScore.toInt();
            //Log.d("ovo",totalMeScoreTemp.toString())
        }

        gameScoreViewModel.miViScoresList.observe(this, scoreObserver)

    }

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

        val rvAdapter = MiViScoreAdapter()
        rvAdapter.updateScoreList(gameScoreViewModel.getPopulatedMiViScoreList())
        binding.gameScoresRV.adapter = rvAdapter
        binding.newEntryButton.setOnClickListener {
            calculatorFragmentTransaction.onNewEntryBtnClick()
        }
    }
}