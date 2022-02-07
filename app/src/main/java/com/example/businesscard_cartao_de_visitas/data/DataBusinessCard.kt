package com.example.businesscard_cartao_de_visitas.data

import androidx.room.Entity
import androidx.room.PrimaryKey


//Anotação que faz a integração com o Room
@Entity
data class DataBusinessCard (

    //O data class vai passar as informações que o banco de dados precisa gravar.
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val empresa: String,
    val telefone: String,
    val email: String,
    val corPersonalizada: String

    //Banco de dados tipo tabelas


)