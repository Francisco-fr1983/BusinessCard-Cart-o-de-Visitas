package com.example.businesscard_cartao_de_visitas.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.businesscard_cartao_de_visitas.App
import com.example.businesscard_cartao_de_visitas.databinding.ActivityAddBusinessCardBinding
import com.example.businesscard_cartao_de_visitas.data.DataBusinessCard

class AddBusinessCard : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater)}

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
        //Pois estamos injentando o repository dentro do ViewModel, para que faça o controle.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        insertListener()
    }

    private fun insertListener() {
        binding.btnClose.setOnClickListener {
            finish()

        }
        binding.btnGravar.setOnClickListener {
            val dataBusinessCard = DataBusinessCard(
                nome = binding.tilName.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                telefone = binding.tilPhone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                corPersonalizada = binding.tilCorDeFundo.editText?.text.toString()

            )
            mainViewModel.insert(dataBusinessCard)
            //Com a criação do ViewModel, no AddBusinessCard.kt, e com a instancia do mainViewModel.insert(dataBusinessCard), desse jeito haverá a persistencia dos dados.

        }

    }

}