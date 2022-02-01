package com.example.businesscard_cartao_de_visitas.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.businesscard_cartao_de_visitas.R

class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}