package com.example.businesscard_cartao_de_visitas.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.businesscard_cartao_de_visitas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}