package com.example.businesscard_cartao_de_visitas.ui


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.businesscard_cartao_de_visitas.App
import com.example.businesscard_cartao_de_visitas.R
import com.example.businesscard_cartao_de_visitas.data.DataBusinessCard
import com.example.businesscard_cartao_de_visitas.databinding.ActivityMainBinding


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    private val adapter: AdapterBuninessCard by lazy {
        AdapterBuninessCard()
    }

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
        binding.btnLixeira.setOnClickListener {
            val dataBusinessCard = DataBusinessCard(
                    id = +0,nome = toString(),empresa = toString(),telefone = toString(),email = toString(),corPersonalizada = toString()

            )
            mainViewModel.deleteCard(dataBusinessCard)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()


            //Com a criação do ViewModel, no AddBusinessCard.kt, e com a instancia do mainViewModel.insert(dataBusinessCard), desse jeito haverá a persistencia dos dados.

        }
        adapter.listenerEdit = { card, databusinessCard ->
            val intent = Intent(this, AddBusinessCard::class.java
            )
            intent.putExtra(AddBusinessCard.CARD_ID, databusinessCard.id)
            startActivity(intent)
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
