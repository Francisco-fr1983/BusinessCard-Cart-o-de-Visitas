package com.example.businesscard_cartao_de_visitas.data

import android.view.View
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class RepositoryBusinessCard (private val dao:DaoBusinessCard) {

    //Repository para fazer a chamada do DAO
    //Repository precisa injetar o nosso DAO

    fun insert(dataBusinessCard: DataBusinessCard) = runBlocking {
        launch(Dispatchers.IO){
            dao.insert(dataBusinessCard)
        }
    }
    fun getAll() = dao.getAll()

    fun deleteCard(dataBusinessCard: DataBusinessCard) = runBlocking {
        launch(Dispatchers.IO){
            dao.deleteCard(dataBusinessCard)
        }
    }

    //suspend fun deleteCard(dataBusinessCard: DataBusinessCard) {
        //dao.deleteCard(dataBusinessCard)




}

