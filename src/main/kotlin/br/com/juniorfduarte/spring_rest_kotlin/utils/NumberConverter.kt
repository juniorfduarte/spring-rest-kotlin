package br.com.juniorfduarte.spring_rest_kotlin.utils

import br.com.juniorfduarte.spring_rest_kotlin.exception.UnsupportedMathOperationException

object NumberConverter {

    fun convertToDouble(strNumber: String?): Double {
        if (strNumber.isNullOrBlank()) return 0.0

        if (!isNumeric(strNumber))
            throw UnsupportedMathOperationException("Please set a numeric value!")

        val number = strNumber.replace(",".toRegex(), ".")

        return if (isNumeric(number)) number.toDouble() else 0.0
    }

    fun isNumeric(strNumber: String): Boolean {
        return strNumber.matches("""[-+]?[0-9]*\.?[0-9]""".toRegex())
    }
}