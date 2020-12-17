package string_calculator

import java.lang.NumberFormatException

class StringCalculator {

    fun add(numbers: String): Int {
        if (numbers.isEmpty()) return 0
        return try {
            var pair = Pair(",", numbers)
            if (numbers.startsWith("//")) {
                val customSeparator = numbers.substringAfter('[').substringBefore(']')
                pair = if (customSeparator != numbers) {
                    Pair(customSeparator, numbers.substring(customSeparator.length + 5))
                } else {
                    Pair(
                        numbers.substringAfter("//").substringBefore("\n"),
                        numbers.substringAfter("\n")
                    )
                }
            }
            val negatives = mutableListOf<Int>()
            val (separator, value) = pair
            val sum = value
                .split(separator, ",", "\n")
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