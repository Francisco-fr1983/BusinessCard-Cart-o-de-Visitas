package com.example.businesscard_cartao_de_visitas.ui


import android.Manifest
import android.content.Intent
import com.example.businesscard_cartao_de_visitas.util.Image
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
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
        setUpPermissions()
        binding.rvCards.adapter = adapter
        getAllDataBusinessCard()
        insertListener()
    }
    private fun setUpPermissions() {
        // Permissão de gravação para acessar o armazenamento
        ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                1
        )
        ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                1
        )
    }


    private fun insertListener() {
        binding.btnFloating.setOnClickListener {
            startActivityForResult(Intent(this, AddBusinessCard::class.java), CREATE_NEW_TASK)
        }
        binding.btnLixeira.setOnClickListener {
            val dataBusinessCard = DataBusinessCard(
                     id = 0,nome = toString(),empresa = toString(),telefone = toString(),email = toString(),corPersonalizada = toString()

            )
            mainViewModel.deleteCard(dataBusinessCard)
            Toast.makeText(this, R.string.label_show_success2, Toast.LENGTH_SHORT).show()


            //Com a criação do ViewModel, no AddBusinessCard.kt, e com a instancia do mainViewModel.insert(dataBusinessCard), desse jeito haverá a persistencia dos dados.

        }
        adapter.listenerEdit = { card, databusinessCard ->
            val intent = Intent(this, AddBusinessCard::class.java
            )
            intent.putExtra(AddBusinessCard.CARD_ID, databusinessCard.id)
            startActivity(intent)

        }
        adapter.listenerShare = { card ->
            Image.share(this@MainActivity, card)

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
