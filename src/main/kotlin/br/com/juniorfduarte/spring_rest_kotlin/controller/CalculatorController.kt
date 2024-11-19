package br.com.juniorfduarte.spring_rest_kotlin.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class CalculatorController {

    val counter: AtomicLong = AtomicLong()

    @GetMapping("/sum")
    fun sum(
        @RequestParam(value = "numberOne") numberOne: String?,
        @RequestParam(value = "numberTwo") numberTwo: String?
    ): Double? {

        val one = convertToDouble(numberOne)
        val two = convertToDouble(numberTwo)
        return one + two
    }

    private fun convertToDouble(strNumber: String?): Double {
        if (strNumber.isNullOrBlank()) return 0.0

        val number = strNumber.replace(",".toRegex(), ".")

        return if (isNumeric(number)) number.toDouble() else 0.0
    }

    private fun isNumeric(strNumber: String): Boolean {
        return strNumber.matches("""[-+]?[0-9]*\.?[0-9]""".toRegex())
    }
}