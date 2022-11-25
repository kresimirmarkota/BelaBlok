package com.example.belablok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.recyclerview.widget.RecyclerView
import com.example.belablok.fragments.CalculatorFragment
import com.example.belablok.fragments.GameScoreFragment

class MainActivity : AppCompatActivity(),OnBtnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun onNewEntryBtnClick() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<CalculatorFragment>(R.id.fragmentContainerView)
        }
    }

}