package string_calculator

class StringCalculator {

    fun add(numbers: String): Int {
        if (numbers.isEmpty()) return 0
        if (numbers.contains(',')) {
            val splitted = numbers.split(',')
            return splitted[0].toInt() + splitted[1].toInt()
        }
        return numbers.toInt()
    }

}
