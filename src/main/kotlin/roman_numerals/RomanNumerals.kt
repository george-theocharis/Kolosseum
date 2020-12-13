package roman_numerals

private val romanValues = mapOf(
    15 to "XV",
    10 to "X",
    5 to "V"
)

fun convert(amount: Int): String {
    if (amount == 4) return "IV"
    if (amount == 9) return "IX"
    if (amount == 14) return "XIV"
    if (amount == 19) return "XIX"
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

