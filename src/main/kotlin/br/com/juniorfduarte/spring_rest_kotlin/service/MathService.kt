package br.com.juniorfduarte.spring_rest_kotlin.service

import br.com.juniorfduarte.spring_rest_kotlin.utils.NumberConverter.convertToDouble
import org.springframework.stereotype.Service
import kotlin.math.sqrt

@Service
class MathService {

    fun sum(numberOne: String?, numberTwo: String?) : Double {
        return convertToDouble(numberOne) + convertToDouble(numberTwo)
    }

    fun minus(numberOne: String?, numberTwo: String?) : Double {
        return convertToDouble(numberOne) - convertToDouble(numberTwo)
    }

    fun multiply(numberOne: String?, numberTwo: String?) : Double {
        return convertToDouble(numberOne) * convertToDouble(numberTwo)
    }

    fun division(numberOne: String?, numberTwo: String?) : Double {
        return convertToDouble(numberOne) / convertToDouble(numberTwo)
    }

    fun average(numberOne: String?, numberTwo: String?) : Double {
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2
    }

    fun squareRoot(numberOne: String?) : Double {
        return sqrt(convertToDouble(numberOne))
    }
}