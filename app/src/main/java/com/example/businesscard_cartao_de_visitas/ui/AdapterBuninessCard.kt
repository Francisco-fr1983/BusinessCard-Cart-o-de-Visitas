package com.example.businesscard_cartao_de_visitas.ui

import android.view.View
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.businesscard_cartao_de_visitas.data.DataBusinessCard
import com.example.businesscard_cartao_de_visitas.databinding.ItensBusinesscardBinding



//Criar o adapter para pegar os dados que estão vindo da lista, e jogar na tela para o usuário ver, ele é responsável pela exibição dos dados de lista na tela.
class AdapterBuninessCard: ListAdapter<DataBusinessCard, AdapterBuninessCard.ViewHolder>(DiffCallback()) {

    var listenerShare: (View) -> Unit = {}

    inner class ViewHolder(
            private val binding: ItensBusinesscardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind (item:DataBusinessCard) {

        }
    }

}