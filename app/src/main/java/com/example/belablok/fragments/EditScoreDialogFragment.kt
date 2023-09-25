package com.example.belablok.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat.recreate
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.belablok.GameScoreViewModel
import com.example.belablok.MainActivity
import com.example.belablok.R
import com.example.belablok.RVAdapterListener
import com.example.belablok.Scores
import com.example.belablok.adapters.MiViScoreAdapter
import com.example.belablok.databinding.DialogFragmentEditItemScoreBinding
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class EditScoreDialogFragment() :DialogFragment() {
    private lateinit var binding: DialogFragmentEditItemScoreBinding
    private lateinit var rvAdapterListener: RVAdapterListener

    private val gameScoreViewModel: GameScoreViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogFragmentEditItemScoreBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("ovu","on attach in dialog fragment")

        if (context is RVAdapterListener){
            rvAdapterListener =context
            Log.d("ovu",rvAdapterListener.toString()+" neki klinac")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mArgs = arguments

        val myValue =mArgs?.getInt("index")


        binding.ourScore.text=Editable.Factory.getInstance().newEditable(gameScoreViewModel.scoreList[myValue!!].miScore)
        binding.yourScore.text=Editable.Factory.getInstance().newEditable(gameScoreViewModel.scoreList[myValue!!].viScore)
        binding.ourCalls.text=Editable.Factory.getInstance().newEditable(gameScoreViewModel.scoreList[myValue!!].miCall)
        binding.yourCalls.text=Editable.Factory.getInstance().newEditable(gameScoreViewModel.scoreList[myValue!!].viCall)

        binding.cancelButton.setOnClickListener {
            dismiss()
        }

        binding.confirmButton.setOnClickListener {

            gameScoreViewModel.scoreList[myValue!!].miScore = binding.ourScore.text.toString()
            gameScoreViewModel.scoreList[myValue!!].viScore = binding.yourScore.text.toString()
            gameScoreViewModel.scoreList[myValue!!].miCall =  binding.ourCalls.text.toString()
            gameScoreViewModel.scoreList[myValue!!].viCall = binding.yourCalls.text.toString()
            gameScoreViewModel.scoreList.set(myValue,Scores(
                    binding.ourScore.text.toString(),
                    binding.yourScore.text.toString(),
                    binding.ourCalls.text.toString(),
                    binding.yourCalls.text.toString()))
            Log.d("ovz","iza edit scora"+gameScoreViewModel.scoreList.toString())


            dismiss()
        }
    }

        companion object{
            const val TAG = "EditScoreDialogFragment"
        }




}