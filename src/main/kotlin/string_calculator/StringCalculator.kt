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
            var negatives = mutableListOf<Int>()
            val sum = valueToSplit.split(separator, ',', '\n').fold(0) { sum: Int, splittedValue: String ->
                val valueToAdd = splittedValue.toInt()
                if(valueToAdd < 0) negatives.add(valueToAdd)
                sum + valueToAdd
            }

            if (negatives.size == 0) return sum
            if(negatives.size == 1) throw NegativesNotAllowedException("")
            val reason = negatives.fold("") { acc, value ->
                "$acc$value "
            }.trimEnd()
            throw NegativesNotAllowedException(reason)

        } catch (e: NumberFormatException) {
            throw BadInputFormatException("Inappropriate input: $numbers")
        }
    }

}

class BadInputFormatException(val reason: String) : Exception()
class NegativesNotAllowedException(reason: String) : Exception(reason)