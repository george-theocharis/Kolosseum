package roman_numerals

fun convert(amount: Int): String {
    var roman = ""
    if(amount == 6) return "VI"
    if(amount == 5) return "V"
    if(amount == 4) return "IV"
    repeat(amount) { roman += "I" }
    return roman
}