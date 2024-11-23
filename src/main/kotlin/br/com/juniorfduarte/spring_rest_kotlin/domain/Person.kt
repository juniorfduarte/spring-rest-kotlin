package br.com.juniorfduarte.spring_rest_kotlin.domain

import br.com.juniorfduarte.spring_rest_kotlin.dto.PersonDTO
import br.com.juniorfduarte.spring_rest_kotlin.enum.PersonGender

data class Person(
    var id: Long = 0,
    var firstName: String = "",
    var lastName: String = "",
    var address: String = "",
    var gender: PersonGender = PersonGender.NOT_DECLARED
) {

    companion object {
        fun fromDTO(dto: PersonDTO): Person {
            return Person(
                id = dto.id,
                firstName = dto.firstName,
                lastName = dto.lastName,
                address = dto.address,
                gender = dto.gender
            )
        }
    }
}

