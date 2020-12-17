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
            val negatives = mutableListOf<Int>()
            val sum = valueToSplit
                .split(separator, ',', '\n')
                .map { it.toInt() }
                .filter { it <= 1000 }
                .fold(0) { sum: Int, value: Int ->
                    if (value < 0) negatives.add(value)
                    sum + value
                }

            if (negatives.size == 0) return sum
            if (negatives.size == 1) throw NegativesNotAllowedException("")
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