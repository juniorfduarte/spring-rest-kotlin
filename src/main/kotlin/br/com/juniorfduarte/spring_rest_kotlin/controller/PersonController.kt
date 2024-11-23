package br.com.juniorfduarte.spring_rest_kotlin.controller

import br.com.juniorfduarte.spring_rest_kotlin.domain.Person
import br.com.juniorfduarte.spring_rest_kotlin.dto.PersonDTO
import br.com.juniorfduarte.spring_rest_kotlin.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController(

    @Autowired
    private val personService: PersonService

) {

    @GetMapping()
    fun findAll(
    ): List<Person> {
        return personService.findAll()
    }

    @GetMapping("/{id}")
    fun findById(
        @PathVariable("id") id: Long?,
    ): Any {
        return personService.findById(id) ?: "Person with Id:$id not found!"
    }

    @PostMapping()
    fun create(
        @RequestBody personDTO: PersonDTO
    ): Person {
        return personService.createPerson(personDTO)
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable("id") id: Long,
        @RequestBody personDTO: PersonDTO
    ): Person {
        return personService.updatePerson(id, personDTO)
    }

    @DeleteMapping("/{id}")
    fun deleteById(
        @PathVariable("id") id: Long,
    ): String {
        return personService.deletePerson(id)
    }

}