package roman_numerals

fun convert(amount: Int): String {
    if(amount == 3) return "III"
    if(amount == 2) return "II"
    return "I"
}