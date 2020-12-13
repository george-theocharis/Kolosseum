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
)

fun convert(amount: Int): String {
    var roman = ""
    var editableAmount = amount
    romanValues.entries.forEach {
        if(editableAmount >= it.key) {
            roman = it.value
            editableAmount = amount - it.key
        }
    }
    repeat(editableAmount) { roman += "I" }
    return roman
}

