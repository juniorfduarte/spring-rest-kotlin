package br.com.juniorfduarte.spring_rest_kotlin.dto

import br.com.juniorfduarte.spring_rest_kotlin.enum.PersonGender

data class PersonDTO (
    val id: Long,
    var firstName: String,
    var lastName: String,
    var address: String,
    var gender: PersonGender = PersonGender.NOT_DECLARED
)

