package string_calculator

import java.lang.NumberFormatException
import java.util.regex.Pattern

class StringCalculator {

    fun add(numbers: String): Int {
        if (numbers.isEmpty()) return 0
        return try {
            val separators = mutableSetOf("\n", ",")
            var toBeSplitted = numbers
            if (numbers.startsWith("//")) {
                var customSeparator = numbers.substringAfter('[').substringBefore(']')
                if (customSeparator != numbers) {
                    var value = numbers
                    while (customSeparator != value) {
                        separators.add(customSeparator)
                        value = value.substringAfter("[$customSeparator]")
                        customSeparator = value.substringAfter('[').substringBefore(']')
                    }
                    toBeSplitted = value.substringAfter("\n")
                } else {
                    separators.add(numbers.substringAfter("//").substringBefore("\n"))
                    toBeSplitted = numbers.substringAfter("\n")
                }
            }

            val negatives = mutableListOf<Int>()
            val sum = toBeSplitted
                .split(Pattern.compile(separators.toString()))
                .filterNot { it == "" }
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