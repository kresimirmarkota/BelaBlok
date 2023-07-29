package com.example.belablok.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.belablok.Scores
import com.example.belablok.databinding.CardviewMiviscoreBinding


class MiViScoreAdapter : RecyclerView.Adapter<MiViScoreAdapter.MiViScoreViewHolder>() {
    private var scoreList: ArrayList<Scores> = ArrayList()

    inner class MiViScoreViewHolder(val binding: CardviewMiviscoreBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                Toast.makeText(binding.root.context, "ovo je tekst neki", Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiViScoreViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardviewMiviscoreBinding.inflate(inflater, parent, false)
        return MiViScoreViewHolder(binding)
    }



    override fun onBindViewHolder(holder: MiViScoreViewHolder, position: Int) {

        holder.binding.ourScoreId.text = scoreList[position].miScore
        holder.binding.yourScoreId.text = scoreList[position].viScore
        holder.binding.ourCallsId.text = scoreList[position].miCall
        holder.binding.yourCallsId.text = scoreList[position].viCall
        holder.binding.redoslijedIgreId.text = (position + 1).toString()

    }

    override fun getItemCount(): Int {
        return scoreList.size
    }

    fun updateScoreList(scoreList: ArrayList<Scores>) {
        this.scoreList.clear()
        this.scoreList = scoreList
    }

    fun getScoreList():ArrayList<Scores>{
        return scoreList
    }
}