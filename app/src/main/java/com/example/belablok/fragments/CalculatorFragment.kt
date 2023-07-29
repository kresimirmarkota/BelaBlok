package com.example.belablok.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.belablok.GameScoreViewModel
import com.example.belablok.OnBtnClickListener
import com.example.belablok.R
import com.example.belablok.Scores

class CalculatorFragment : Fragment(R.layout.fragment_calculator) {
    private val gameScoreViewModel: GameScoreViewModel by activityViewModels()
    private lateinit var ourScoreEditText: EditText
    private lateinit var yourScoreEditText: EditText
    private lateinit var ourCallsEditText: EditText
    private lateinit var yourCallsEditText: EditText
    private lateinit var potvrdiButton: Button
    private lateinit var resetButton: Button
    private lateinit var onAcceptButton: OnBtnClickListener


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnBtnClickListener) {
            onAcceptButton = context
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ourScoreEditText = view.findViewById(R.id.ourScore)
        yourScoreEditText = view.findViewById(R.id.yourScore)
        ourCallsEditText = view.findViewById(R.id.ourCalls)
        yourCallsEditText = view.findViewById(R.id.yourCalls)
        potvrdiButton = view.findViewById(R.id.confirmButton)
        resetButton = view.findViewById(R.id.reset_button)

        potvrdiButton.setOnClickListener {
            if (ourScoreEditText.text.isEmpty() or ourCallsEditText.text.isEmpty() or
                yourScoreEditText.text.isEmpty() or yourCallsEditText.text.isEmpty()
            ) {
                Toast.makeText(
                    context,
                    getString(R.string.no_data_entered_warning),
                    Toast.LENGTH_SHORT
                ).show()

            } else {
                gameScoreViewModel._miViScoresList.value =
                    Scores(
                        ourScoreEditText.text.toString(),
                        yourScoreEditText.text.toString(),
                        ourCallsEditText.text.toString(),
                        yourCallsEditText.text.toString()
                    )
                gameScoreViewModel.populateMiViScoreList()
                onAcceptButton.onAcceptBtnClick()
            }
        }
        resetButton.setOnClickListener {
            ourScoreEditText.setText("")
            ourCallsEditText.setText("")
            yourScoreEditText.setText("")
            yourCallsEditText.setText("")

        }
    }


}