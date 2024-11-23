package br.com.juniorfduarte.spring_rest_kotlin.service

import br.com.juniorfduarte.spring_rest_kotlin.domain.Person
import br.com.juniorfduarte.spring_rest_kotlin.dto.PersonDTO
import br.com.juniorfduarte.spring_rest_kotlin.exception.UnsupportedMathOperationException
import br.com.juniorfduarte.spring_rest_kotlin.repository.PersonRepository
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService(
    val personRepository: PersonRepository
) {

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll() : MutableList<Person> {
        val people = personRepository.peopleList()

        logger.info("m=findAll; msg=Found ${people.size} people.")

        return people
    }

    fun findById(id: Long?) : Person? {

        if (id == null)
            throw UnsupportedMathOperationException("Please, insert the person ID.")

        val person = personRepository.findById(id)

        logger.info("m=findById; msg=Found person: id=${id}, name=${person?.firstName}")

        return person
    }

    fun createPerson(personDto: PersonDTO): Person {
        val person = Person.fromDTO(personDto)

        personRepository.peopleList().add(person)

        logger.info("m=createPerson; msg=Person created with success!")

        return person
    }

    fun updatePerson(personId: Long, personDto: PersonDTO): Person {
        val person = Person.fromDTO(personDto)

        val test =  personRepository.peopleList().find { it.id == personId }?.apply {
            id = personId
            firstName = personDto.firstName
            lastName = personDto.lastName
            address = personDto.address
            gender = personDto.gender
        }

        logger.info("m=updatePerson; msg=Person updated with success!")

        return person
    }

    fun updatePerson2(personId: Long, personDto: PersonDTO): MutableList<Person> {
        val list =  personRepository.peopleList()

        list.find { it.id == personId }?.apply {
            id = personId
            firstName = personDto.firstName
            lastName = personDto.lastName
            address = personDto.address
            gender = personDto.gender
        }

        logger.info("m=updatePerson; msg=Person updated with success!")

        return list
    }

    fun deletePerson(personId: Long): String {
        val person = personRepository.peopleList().find { it.id == personId }

        if(person == null) {
            logger.info("m=deletePerson; msg=Person with ID:$personId not found!")
            return "Person with ID:$personId not found!"
        }

        personRepository.peopleList().remove(person)

        return "Person with ID:${person.id} deleted!"
    }


}