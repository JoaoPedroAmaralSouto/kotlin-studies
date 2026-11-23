package br.edu.iftm.estudo_trabalho_3.application

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import br.edu.iftm.estudo_trabalho_3.domain.Kid


@Dao
interface KidDAO {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(kid: Kid): Long

    @Query("SELECT * FROM kid_table WHERE kid_cpf = :cpf")
    suspend fun search_by_cpf(cpf: String): Kid?

    @Query("SELECT * FROM kid_table ORDER BY kid_name")
    suspend fun search_all(): List<Kid>?

    @Update
    suspend fun update(kid: Kid)

    @Delete
    suspend fun delete(kid: Kid)

    @Query("DELETE FROM kid_table WHERE kid_cpf = :cpf")
    suspend fun delete_by_cpf(cpf: String)
}