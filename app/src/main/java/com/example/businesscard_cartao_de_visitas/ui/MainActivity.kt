package com.example.businesscard_cartao_de_visitas.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.businesscard_cartao_de_visitas.App
import com.example.businesscard_cartao_de_visitas.data.DataBusinessCard
import com.example.businesscard_cartao_de_visitas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
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
            startActivityForResult(Intent(this, AddBusinessCard::class.java), CREATE_NEW_TASK)
        }
        adapter.listenerEdit = {
            val intent = Intent(this, AddBusinessCard::class.java)
            intent.putExtra(AddBusinessCard.CARD_ID, it.id)
            startActivityForResult(intent, UPDATE_CARD)
        }
        adapter.listenerDelete = {

            //mainViewModel.deleteCard(dataBusinessCard = DataBusinessCard(this))

        }

    }
    private fun getAllDataBusinessCard() {
        mainViewModel.getAll().observe(this, { dataBusinessCard ->
            adapter.submitList(dataBusinessCard)
        })
    }
    companion object{
        private const val CREATE_NEW_TASK = 1000
        private const val UPDATE_CARD = 1001
    }
}