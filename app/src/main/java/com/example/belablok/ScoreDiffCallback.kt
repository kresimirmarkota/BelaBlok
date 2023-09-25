package com.example.belablok

import androidx.recyclerview.widget.DiffUtil

class ScoreDiffCallback(mOldScoreList: List<Scores>, mNewScoreList : List<Scores>) : DiffUtil.Callback() {

    private var mOldScoreList : List<Scores>
    private var mNewScoreList : List<Scores>

    init {
        this.mOldScoreList=mOldScoreList
        this.mNewScoreList=mNewScoreList
    }
    override fun getOldListSize(): Int {
        return mOldScoreList.size
    }

    override fun getNewListSize(): Int {
       return mNewScoreList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldScoreList.get(oldItemPosition) ==mNewScoreList.get(newItemPosition)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            var oldScore : Scores = mOldScoreList.get(oldItemPosition)
            var newScore : Scores = mNewScoreList.get(newItemPosition)

        return oldScore.equals(newScore)
    }
    public override fun  getChangePayload(oldItemPosition : Int, newItemPosition:Int): Any? {

        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}