package com.example.businesscard_cartao_de_visitas

import android.app.Application
import com.example.businesscard_cartao_de_visitas.data.AppDatabase
import com.example.businesscard_cartao_de_visitas.data.RepositoryBusinessCard

class App : Application() {

    //App na hora que a class App iniciar, temos que instanciar os AppDatabase e RepositoryBusinessCard.

    private val database: AppDatabase by lazy {
        AppDatabase.getDatabase(this)
    }
    val repository: RepositoryBusinessCard by lazy {
        RepositoryBusinessCard(database.daoBusinessCard())
    }

}