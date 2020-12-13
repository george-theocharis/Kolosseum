package roman_numerals

fun convert(amount: Int): String {
    var roman = ""
    repeat(amount) { roman += "I" }
    return roman
}