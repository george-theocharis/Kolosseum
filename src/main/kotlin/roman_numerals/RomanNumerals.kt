package roman_numerals

fun convert(amount: Int): String {
    if(amount == 9) return "IX"
    var roman = ""
    var editableAmount = amount
    if(amount >= 5) {
        roman = "V"
        editableAmount = amount - 5
    }
    if(editableAmount == 4) return "IV"
    repeat(editableAmount) { roman += "I" }
    return roman
}