package string_calculator

class StringCalculator {

    fun add(numbers: String): Int {
        if(numbers.isEmpty()) return 0
        return numbers.toInt()
    }

}
