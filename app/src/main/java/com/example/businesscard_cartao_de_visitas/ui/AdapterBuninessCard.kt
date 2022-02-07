package com.example.businesscard_cartao_de_visitas.ui

import android.widget.ListAdapter
import com.example.businesscard_cartao_de_visitas.data.DataBusinessCard


//Criar o adapter para pegar os dados que estão vindo da lista, e jogar na tela para o usuário ver, ele é responsável pela exibição dos dados de lista na tela.
class AdapterBuninessCard: ListAdapter<DataBusinessCard, AdapterBuninessCard.ViewHolder>(DiffCallback()) {

}