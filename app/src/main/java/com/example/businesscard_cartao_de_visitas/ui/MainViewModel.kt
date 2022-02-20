package com.example.businesscard_cartao_de_visitas.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.businesscard_cartao_de_visitas.data.DataBusinessCard
import com.example.businesscard_cartao_de_visitas.data.RepositoryBusinessCard


class MainViewModel(private val repositoryBusinessCard: RepositoryBusinessCard) : ViewModel() {
    //Vamos criar o ViewModel para que possa trafegar os dados entre o Repository e nossa tela = UI=View

    fun insert(dataBusinessCard: DataBusinessCard) {
        repositoryBusinessCard.insert(dataBusinessCard)


    }
    fun getAll() : LiveData<List<DataBusinessCard>> {
        return repositoryBusinessCard.getAll()
    }

    fun deleteCard(dataBusinessCard: DataBusinessCard) {
        repositoryBusinessCard.deleteCard(dataBusinessCard)


    //fun deleteCard(dataBusinessCard: DataBusinessCard) {
        //viewModelScope.launch (Dispatchers.IO ) {repositoryBusinessCard.deleteCard(dataBusinessCard)}


    }




}
//Para que a ViewModel funcione precisamos criar uma factory, pois como não estamos usando nada para injeção de dependencia usaremos o factory para injetar manualmente.

class MainViewModelFactory(private val repository: RepositoryBusinessCard
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }

}
