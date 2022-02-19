package com.example.businesscard_cartao_de_visitas.data

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface DaoBusinessCard {

    //O DAO que seria uma class que vai fazer a persistencia de dados, que via fazer as chamadas ao BD.
    //O DAO vai fazer as chamadas do data class DataBusinessCard.

    @Query("SELECT * FROM DataBusinessCard")
    fun getAll(): LiveData<List<DataBusinessCard>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(dataBusinessCard: DataBusinessCard)

    @Update
    suspend fun updateCard(dataBusinessCard: DataBusinessCard)

    @Delete
    suspend fun deleteCard(dataBusinessCard: DataBusinessCard)

    //Deleta todas as DataBusinessCard
    //@Query("DELETE FROM databusinesscard")
    //fun deleteAll()



}