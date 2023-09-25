package com.example.belablok

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
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
    override fun onAcceptBtnClick() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<GameScoreFragment>(R.id.fragmentContainerView)
        }
    }
}