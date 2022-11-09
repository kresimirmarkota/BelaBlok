package com.example.belablok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.belablok.fragments.CalculatorFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, CalculatorFragment())
            .commit()
    }
}