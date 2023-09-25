package com.example.belablok.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.belablok.GameScoreViewModel
import com.example.belablok.OnBtnClickListener
import com.example.belablok.R
import com.example.belablok.Scores
import com.example.belablok.databinding.FragmentCalculatorBinding

class CalculatorFragment : Fragment(R.layout.fragment_calculator) {
    private lateinit var binding: FragmentCalculatorBinding
    private val gameScoreViewModel: GameScoreViewModel by activityViewModels()
    private lateinit var onAcceptButton: OnBtnClickListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnBtnClickListener) {
            onAcceptButton = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalculatorBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.confirmButton.setOnClickListener {
            if (binding.ourScore.text.isEmpty() or binding.ourCalls.text.isEmpty() or
                binding.yourScore.text.isEmpty() or binding.yourCalls.text.isEmpty()
            ) {
                Toast.makeText(
                    context,
                    getString(R.string.no_data_entered_warning),
                    Toast.LENGTH_SHORT
                ).show()

            } else {
//                gameScoreViewModel._miViScoresList.value =
//                    Scores(
//                        binding.ourScore.text.toString(),
//                        binding.yourScore.text.toString(),
//                        binding.ourCalls.text.toString(),
//                        binding.yourCalls.text.toString()
//                    )
                gameScoreViewModel.populateMiViScoreList(Scores(
                    binding.ourScore.text.toString(),
                    binding.yourScore.text.toString(),
                    binding.ourCalls.text.toString(),
                    binding.yourCalls.text.toString()
                ))
                onAcceptButton.onAcceptBtnClick()
            }
        }
        binding.resetButton.setOnClickListener {
            binding.ourScore.setText("")
            binding.ourCalls.setText("")
            binding.yourScore.setText("")
            binding.yourCalls.setText("")

        }
    }
}