package string_calculator

import java.lang.NumberFormatException

class StringCalculator {

    fun add(numbers: String): Int {
        if (numbers.isEmpty()) return 0
        if (numbers.contains(',')) {
            val splitted = numbers.split(',')
            return splitted[0].toInt() + splitted[1].toInt()
        }
        return try {
            numbers.toInt()
        } catch (e: NumberFormatException) {
            throw BadInputFormatException("Inappropriate input: $numbers")
        }
    }

}

class BadInputFormatException(val reason:String) : Exception()