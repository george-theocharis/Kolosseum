package string_calculator

import java.lang.NumberFormatException

class StringCalculator {

    fun add(numbers: String): Int {
        if (numbers.isEmpty()) return 0
        return try {
            var separator = ','
            var valueToSplit = numbers
            if (numbers.startsWith("//")) {
                separator = numbers[2]
                valueToSplit = numbers.substring(4)
            }

            valueToSplit.split(separator, ',', '\n').fold(0) { sum: Int, splittedValue: String ->
                val valueToAdd = splittedValue.toInt()
                if(valueToAdd < 0) throw NegativesNotAllowedException()
                sum + valueToAdd
            }
        } catch (e: NumberFormatException) {
            throw BadInputFormatException("Inappropriate input: $numbers")
        }
    }

}

class BadInputFormatException(val reason: String) : Exception()
class NegativesNotAllowedException : Exception()