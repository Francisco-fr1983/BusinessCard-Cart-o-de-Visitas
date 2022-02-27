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
    //Lond é o id do registro que foi incluido no DataBusinessCard=>@Entity(indices = [Index("id, unique = true")])

    @Delete
    suspend fun deleteCard(dataBusinessCard: DataBusinessCard)

    @Update
    fun updateCard(dataBusinessCard: DataBusinessCard)

    //@Query("DELETE FROM DataBusinessCard WHERE Id = :id")
    //suspend fun deleteCard(id: Int?)

    @Query("SELECT * FROM DataBusinessCard WHERE id = :dataBusinessCardid")
    fun findById(dataBusinessCardid:Int) :DataBusinessCard


}