package br.com.juniorfduarte.spring_rest_kotlin.controller

import br.com.juniorfduarte.spring_rest_kotlin.service.MathService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CalculatorController(

    @Autowired
    private val mathService: MathService

) {

    @GetMapping("/sum")
    fun sum(
        @RequestParam(value = "numberOne") numberOne: String?,
        @RequestParam(value = "numberTwo") numberTwo: String?
    ): Double? {
        return mathService.sum(numberOne, numberTwo)
    }

    @GetMapping("/minus")
    fun minus(
        @RequestParam(value = "numberOne") numberOne: String?,
        @RequestParam(value = "numberTwo") numberTwo: String?
    ): Double? {
        return mathService.minus(numberOne, numberTwo)
    }

    @GetMapping("/multiply")
    fun multiply(
        @RequestParam(value = "numberOne") numberOne: String?,
        @RequestParam(value = "numberTwo") numberTwo: String?
    ): Double? {
        return mathService.multiply(numberOne, numberTwo)
    }

    @GetMapping("/division")
    fun division(
        @RequestParam(value = "numberOne") numberOne: String?,
        @RequestParam(value = "numberTwo") numberTwo: String?
    ): Double? {
        return mathService.division(numberOne, numberTwo)
    }

    @GetMapping("/average")
    fun average(
        @RequestParam(value = "numberOne") numberOne: String?,
        @RequestParam(value = "numberTwo") numberTwo: String?
    ): Double? {
        return mathService.average(numberOne, numberTwo)
    }

    @GetMapping("/square_root")
    fun sqrRoot(
        @RequestParam(value = "numberOne") numberOne: String?
    ): Double? {
        return mathService.squareRoot(numberOne)
    }
}