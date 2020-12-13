package roman_numerals

fun convert(amount: Int): String {
    if(amount == 4) return "IV"
    if(amount == 9) return "IX"
    if(amount == 10) return "X"
    var roman = ""
    var editableAmount = amount
    if(amount >= 5) {
        roman = "V"
        editableAmount = amount - 5
    }
    repeat(editableAmount) { roman += "I" }
    return roman
}