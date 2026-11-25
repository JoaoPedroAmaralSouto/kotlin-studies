package br.edu.iftm.estudo_trabalho_3.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kid_table")
data class Kid(
    @PrimaryKey
    val kid_cpf: String,
    val kid_parent_cpf: String,
    val kid_name: String,
    val kid_parent_email: String,
    val kid_parent_tel: String,
    val kid_age: Int,
    val kid_parent_name: String,
    val kid_professional_name: String
)
