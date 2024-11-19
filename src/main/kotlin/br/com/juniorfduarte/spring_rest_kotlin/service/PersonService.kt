package br.com.juniorfduarte.spring_rest_kotlin.service

import br.com.juniorfduarte.spring_rest_kotlin.domain.Person
import br.com.juniorfduarte.spring_rest_kotlin.enum.PersonGender
import br.com.juniorfduarte.spring_rest_kotlin.exception.UnsupportedMathOperationException
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    private val logger = Logger.getLogger(PersonService::class.java.name)

    private val person = Person(
        id = 1L,
        firstName = "Francisco",
        lastName = "Junior",
        address = "Endereço 123",
        gender = PersonGender.MALE
    )

    fun findById(id: String?) : Person {
        if (id.isNullOrBlank())
            throw UnsupportedMathOperationException("Please, insert the person ID.")

        logger.info("m=findById; msg=Searching person with id=${id}")

        val person1 = person

        logger.info("m=findById; msg=Found person: id=${id}, name=${person1.firstName}")

        return person1
    }

}