package string_calculator

import java.lang.NumberFormatException
import java.util.regex.Pattern

class StringCalculator {

    fun add(numbers: String): Int {
        if (numbers.isEmpty()) return 0
        return try {
            val separators = mutableSetOf("\n", ",")
            val (sum, negatives) = addValues(supportsCustomSeparator(numbers, separators), separators)
            when (negatives.size) {
                0 -> return sum
                else -> {
                    throw NegativesNotAllowedException(
                        negatives.fold("") { acc, value -> "$acc$value " }.trimEnd()
                    )
                }
            }
        } catch (e: NumberFormatException) {
            throw BadInputFormatException("Inappropriate input: $numbers")
        }
    }

    private fun addValues(
        toBeSplit: String,
        separators: MutableSet<String>
    ): Pair<Int, MutableList<Int>> {
        val negatives = mutableListOf<Int>()
        val total = toBeSplit
            .split(Pattern.compile(separators.toString()))
            .filterNot { it == "" }
            .map { it.toInt() }
            .filter { it <= 1000 }
            .fold(0) { sum: Int, value: Int ->
                if (value < 0) negatives.add(value)
                sum + value
            }
        return Pair(total, negatives)
    }

    private fun supportsCustomSeparator(
        initial: String,
        separators: MutableSet<String>
    ) = if (initial.startsWith("//")) {
        var value = initial
        var customSeparator = extractCustomSeparator(initial)
        if (customSeparator == initial) {
            separators.add(initial.substringAfter("//").substringBefore("\n"))
        } else {
            while (customSeparator != value) {
                separators.add(customSeparator)
                value = removeCustomSeparator(value, customSeparator)
                customSeparator = extractCustomSeparator(value)
            }
        }
        initial.substringAfter("\n")
    } else initial

    private fun removeCustomSeparator(value: String, customSeparator: String) =
        value.substringAfter("[$customSeparator]")

    private fun extractCustomSeparator(numbers: String) = numbers.substringAfter('[').substringBefore(']')

}

class BadInputFormatException(val reason: String) : Exception()
class NegativesNotAllowedException(reason: String) : Exception(reason)