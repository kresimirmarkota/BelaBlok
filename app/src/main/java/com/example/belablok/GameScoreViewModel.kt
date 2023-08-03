package com.example.belablok

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class GameScoreViewModel : ViewModel() {
    var _miViScoresList: MutableLiveData<Scores> = MutableLiveData<Scores>()
    var miViScoresList: LiveData<Scores> = _miViScoresList
    private var scoreList: ArrayList<Scores> = ArrayList()

    fun getMiViScoreList(): MutableLiveData<Scores> {
        return _miViScoresList
    }

   fun populateMiViScoreList() {
        scoreList.add(
            Scores(
                getMiViScoreList().value!!.miScore,
                getMiViScoreList().value!!.viScore,
                getMiViScoreList().value!!.miCall,
                getMiViScoreList().value!!.viCall,
            )
        )

    }

    fun getPopulatedMiViScoreList(): ArrayList<Scores> {
        return scoreList
    }

}





