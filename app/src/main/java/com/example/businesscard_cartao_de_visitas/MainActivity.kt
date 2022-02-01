package com.example.businesscard_cartao_de_visitas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    /*Com isso não precisar mais acessar um componente na tela acessar utilizando findViewById*/
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    /*Inicializar ou chamar a nossa ViewModel*/
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }
    private val adapter by lazy { BusinessCardAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}