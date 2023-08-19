package com.example.belablok.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.belablok.Scores
import com.example.belablok.databinding.CardviewMiviscoreBinding
import com.example.belablok.fragments.EditScoreDialogFragment


class MiViScoreAdapter(private val fragmentManager :FragmentManager) : RecyclerView.Adapter<MiViScoreAdapter.MiViScoreViewHolder>() {
    private var scoreList: ArrayList<Scores> = ArrayList()

    //private var onViewHolderItemClick:OnViewHolderItemClick

    inner class MiViScoreViewHolder(val binding: CardviewMiviscoreBinding, private val fragmentManager: FragmentManager) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {

               // Toast.makeText(binding.root.context, "ovo je tekst neki", Toast.LENGTH_LONG).show()
                EditScoreDialogFragment().show(fragmentManager,EditScoreDialogFragment.TAG)

            }
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiViScoreViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardviewMiviscoreBinding.inflate(inflater, parent, false)
        return MiViScoreViewHolder(binding,fragmentManager)
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