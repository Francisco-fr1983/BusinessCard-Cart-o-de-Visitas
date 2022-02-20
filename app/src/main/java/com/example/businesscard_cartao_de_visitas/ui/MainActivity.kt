package com.example.businesscard_cartao_de_visitas.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.businesscard_cartao_de_visitas.App
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
            startActivityForResult(intent, CREATE_NEW_TASK)
        }
        adapter.listenerDelete = {
           //mainViewModel.deleteCard()


        }



    }
    private fun getAllDataBusinessCard() {
        mainViewModel.getAll().observe(this, { dataBusinessCard ->
            adapter.submitList(dataBusinessCard)
        })
    }
    companion object{
        private const val CREATE_NEW_TASK = 1000

    }
}