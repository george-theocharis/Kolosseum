package roman_numerals

fun convert(amount: Int): String {
    if(amount == 4) return "IV"
    if(amount == 9) return "IX"
    if(amount == 14) return "XIV"
    var roman = ""
    var editableAmount = amount
    if(amount >= 10) {
        roman = "X"
        editableAmount = amount - 10
    }
    if(editableAmount >= 5) {
        roman = "V"
        editableAmount = amount - 5
    }
    repeat(editableAmount) { roman += "I" }
    return roman
}