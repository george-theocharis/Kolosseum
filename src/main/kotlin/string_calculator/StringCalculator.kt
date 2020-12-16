package string_calculator

import java.lang.NumberFormatException

class StringCalculator {

    fun add(numbers: String): Int {
        if (numbers.isEmpty()) return 0
        return try {
            numbers.split(',').fold(0) { sum: Int, splittedValue: String ->
                sum + splittedValue.toInt()
            }
        } catch (e: NumberFormatException) {
            throw BadInputFormatException("Inappropriate input: $numbers")
        }
    }

}

class BadInputFormatException(val reason: String) : Exception()