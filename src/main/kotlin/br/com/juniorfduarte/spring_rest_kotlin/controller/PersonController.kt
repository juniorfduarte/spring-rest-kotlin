package br.com.juniorfduarte.spring_rest_kotlin.controller

import br.com.juniorfduarte.spring_rest_kotlin.domain.Person
import br.com.juniorfduarte.spring_rest_kotlin.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person")
class PersonController(

    @Autowired
    private val personService: PersonService

) {

    @GetMapping("/{id}")
    fun findById(
        @PathVariable("id") id: Long?,
    ): Person {
        return personService.findById(id)
    }

}