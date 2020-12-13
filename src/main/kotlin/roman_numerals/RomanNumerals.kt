package roman_numerals

private val romanValues = mapOf(
    20 to "XX",
    19 to "XIX",
    15 to "XV",
    14 to "XIV",
    10 to "X",
    9 to "IX",
    5 to "V",
    4 to "IV",
    1 to "I"
)

fun convert(amount: Int): String {
    var roman = ""
    var editableAmount = amount
    romanValues.entries.forEach {
        while(editableAmount >= it.key) {
            roman += it.value
            editableAmount -= it.key
        }
    }
    return roman
}

