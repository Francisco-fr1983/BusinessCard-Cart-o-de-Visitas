package com.example.businesscard_cartao_de_visitas.data



import androidx.annotation.WorkerThread
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class RepositoryBusinessCard (private val dao:DaoBusinessCard) {

    //Repository para fazer a chamada do DAO
    //Repository precisa injetar o nosso DAO

    fun insert(dataBusinessCard: DataBusinessCard) = runBlocking {
        launch(Dispatchers.IO) {
            dao.insert(dataBusinessCard)
        }
    }
    fun updateCard(dataBusinessCard: DataBusinessCard) = runBlocking {
        launch(Dispatchers.IO){
            dao.updateCard(dataBusinessCard)
        }
    }

    @WorkerThread
    fun deleteCard(dataBusinessCard: DataBusinessCard) = runBlocking {
        launch(Dispatchers.IO) {
            dao.deleteCard(dataBusinessCard)
        }
    }
    fun getAll() = dao.getAll()

    fun findById(dataBusinessCard: Int): DataBusinessCard = dao.findById(dataBusinessCard)

}


