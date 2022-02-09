package com.example.businesscard_cartao_de_visitas.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import com.example.businesscard_cartao_de_visitas.databinding.ActivityMainBinding
import com.example.businesscard_cartao_de_visitas.App

@Suppress("COMPATIBILITY_WARNING")
class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    //Para conectar o nosso ViewModel com a nossa Activity principal no caso MainActivity, faremos a declaração dela
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
        //Pois estamos injentando o repository dentro do ViewModel, para que faça o controle.

    }
    private val adapter by lazy { AdapterBuninessCard() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCards.adapter = adapter
        getAllDataBusinessCard()
        insertListener()
    }

    private fun insertListener() {
        binding.btnFloating.setOnClickListener {
            val intent = Intent(this@MainActivity, AddBusinessCard::class.java)
            startActivity(intent)
        }
    }
    //Função para notificar as informações, para buscar as alterações dos cartões de visita.
    private fun getAllDataBusinessCard() {
        mainViewModel.getAll().observe(this, { dataBusinessCard ->
            adapter.submitList(dataBusinessCard)

        })

    }

}