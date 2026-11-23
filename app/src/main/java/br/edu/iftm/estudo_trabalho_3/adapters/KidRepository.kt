package br.edu.iftm.estudo_trabalho_3.adapters

import br.edu.iftm.estudo_trabalho_3.application.KidDAO
import br.edu.iftm.estudo_trabalho_3.domain.Kid
import kotlinx.coroutines.flow.Flow

class KidRepository(private val dao: KidDAO) {

    val kids: Flow<List<Kid>?> = dao.search_all()
    suspend fun save(kid: Kid) = dao.insert(kid)
    suspend fun delete_by_cpf(cpf: String) = dao.delete_by_cpf(cpf)
    suspend fun delete(kid: Kid) = dao.delete(kid)
    suspend fun update(kid: Kid) = dao.update(kid)
}