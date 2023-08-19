package com.example.belablok

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GameScoreViewModel : ViewModel() {
    var _miViScoresList: MutableStateFlow<Scores> =
        MutableStateFlow<Scores>(Scores("0", "0", "0", "0"))
    var miViScoresList: StateFlow<Scores> = _miViScoresList
    var scoreList: ArrayList<Scores> = ArrayList()
    var scoreMeList: ArrayList<Int> = ArrayList()
    var scoreYouList: ArrayList<Int> = ArrayList()
    var callMeList: ArrayList<Int> = ArrayList()
    var callYouList: ArrayList<Int> = ArrayList()

    fun getMiViScoreList(): MutableStateFlow<Scores> {
        return _miViScoresList
    }

    init {

        viewModelScope.launch { }
    }

    fun populateMiViScoreList() {
        scoreList.add(
            Scores(
                getMiViScoreList().value.miScore,
                getMiViScoreList().value.viScore,
                getMiViScoreList().value.miCall,
                getMiViScoreList().value.viCall,
            )
        )

    }

    fun getPopulatedMiViScoreList(): ArrayList<Scores> {
        return scoreList
    }

}





