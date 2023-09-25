package com.example.belablok.adapters

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.belablok.RVAdapterListener
import com.example.belablok.ScoreDiffCallback
import com.example.belablok.Scores
import com.example.belablok.databinding.CardviewMiviscoreBinding
import com.example.belablok.fragments.EditScoreDialogFragment
import com.example.belablok.fragments.GameScoreFragment


class MiViScoreAdapter(private val fragmentManager :FragmentManager) : RecyclerView.Adapter<MiViScoreAdapter.MiViScoreViewHolder>(){
    private var scoreList: ArrayList<Scores> = ArrayList()


    inner class MiViScoreViewHolder(val binding: CardviewMiviscoreBinding, private val fragmentManager: FragmentManager) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                val dialogFragment = EditScoreDialogFragment()
                val args = Bundle()
                args.putInt("index",position)

                dialogFragment.arguments=args

                dialogFragment.show(fragmentManager,EditScoreDialogFragment.TAG)
            }
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiViScoreViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardviewMiviscoreBinding.inflate(inflater, parent, false)
        Log.d("ovo","onCreateViewHolder")
        return MiViScoreViewHolder(binding,fragmentManager)
    }
    override fun onBindViewHolder(holder: MiViScoreViewHolder, position: Int) {

        holder.binding.ourScoreId.text = scoreList[position].miScore
        holder.binding.yourScoreId.text = scoreList[position].viScore
        holder.binding.ourCallsId.text = scoreList[position].miCall
        holder.binding.yourCallsId.text = scoreList[position].viCall
        holder.binding.redoslijedIgreId.text = (position + 1).toString()
        Log.d("ovo","onBindViewHolder")

    }
    override fun getItemCount(): Int {
        return scoreList.size
    }
     fun  updateScoreList(scoreList: ArrayList<Scores>) {

        this.scoreList.clear()
        this.scoreList = scoreList
    }
    fun getScoreList():ArrayList<Scores>{
        return scoreList
    }

    fun updateScoreListItems(scores : List<Scores>){
        var diffCallback:ScoreDiffCallback = ScoreDiffCallback(this.scoreList,scores)
        var diffResult : DiffUtil.DiffResult = DiffUtil.calculateDiff(diffCallback)

        this.scoreList.clear()
        this.scoreList.addAll(scores)
        diffResult.dispatchUpdatesTo(this)
    }

}