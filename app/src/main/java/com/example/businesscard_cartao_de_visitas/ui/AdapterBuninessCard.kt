package com.example.businesscard_cartao_de_visitas.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.businesscard_cartao_de_visitas.data.DataBusinessCard
import com.example.businesscard_cartao_de_visitas.databinding.ItensBusinesscardBinding


//Criar o adapter para pegar os dados que estão vindo da lista, e jogar na tela para o usuário ver, ele é responsável pela exibição dos dados de lista na tela.

class AdapterBuninessCard: ListAdapter<DataBusinessCard, AdapterBuninessCard.ViewHolder>(DiffCallback()) {

    //Eventos -> listenerEdit e listenerDelete
    var listenerEdit: (View, DataBusinessCard) -> Unit = { _, _: DataBusinessCard -> }
    var listenerDelete: (View) -> Unit = {}
    var listenerShare: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItensBusinesscardBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class ViewHolder(
            private val binding: ItensBusinesscardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DataBusinessCard) {
            binding.tvName.text = item.nome
            binding.tvEmpresa.text = item.empresa
            binding.tvPhone.text = item.telefone
            binding.tvEmail.text = item.email
            binding.mcvContent.setCardBackgroundColor(Color.parseColor(item.corPersonalizada)
            )
            binding.ivLapis.setOnClickListener {
                listenerEdit(binding.ivLapis, item)
            }

            binding.ivLixeira.setOnClickListener {
                listenerDelete(it)
            }

            binding.ivShare.setOnClickListener {
                listenerShare(it)
            }

        }

    }

}

class DiffCallback: DiffUtil.ItemCallback<DataBusinessCard>() {
    override fun areItemsTheSame(oldItem: DataBusinessCard, newItem: DataBusinessCard) :Boolean {
        return  oldItem.id == newItem.id &&
                oldItem.nome == newItem.nome &&
                oldItem.email == newItem.email &&
                oldItem.empresa == newItem.empresa &&
                oldItem.corPersonalizada == newItem.corPersonalizada
    }

    override fun areContentsTheSame(oldItem: DataBusinessCard, newItem: DataBusinessCard): Boolean {
        return oldItem.id == newItem.id &&
                oldItem.nome == newItem.nome &&
                oldItem.email == newItem.email &&
                oldItem.empresa == newItem.empresa &&
                oldItem.corPersonalizada == newItem.corPersonalizada
    }

}


//Após finalização do adapter, temos que chamar ele lá na MainActivity.