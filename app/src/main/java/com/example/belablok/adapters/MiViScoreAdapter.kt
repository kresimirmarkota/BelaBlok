package com.example.belablok.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.belablok.R

class MiViScoreAdapter : RecyclerView.Adapter<MiViScoreAdapter.MiViScoreViewHolder>() {

    inner class MiViScoreViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        var miScoreTv: TextView
        var viScoreTv: TextView
        var miCallTv: TextView
        var viCallTv: TextView

        init {
            miScoreTv = view.findViewById(R.id.ourScoreId)
            viScoreTv = view.findViewById(R.id.yourScoreId)
            viCallTv = view.findViewById(R.id.yourCallsId)
            miCallTv = view.findViewById(R.id.ourCallsId)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiViScoreViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.cardview_miviscore, parent, false)

        return MiViScoreViewHolder(view)
    }

    override fun onBindViewHolder(holder: MiViScoreViewHolder, position: Int) {
        holder.viScoreTv.text = "--"
        holder.viCallTv.text = "--"
        holder.miCallTv.text = "--"
        holder.miScoreTv.text = "--"
    }

    override fun getItemCount(): Int {
        return 1
    }
}