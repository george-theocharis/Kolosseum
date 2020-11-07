package fizz_buzz

class FizzBuzz {

    operator fun invoke(number: Int) = when {
        number.isMultipleOf(3, 5) -> "FizzBuzz"
        number.isMultipleOf(3) -> "Fizz"
        number.isMultipleOf(5) -> "Buzz"
        else -> number.toString()
    }

    private fun Int.isMultipleOf(vararg div: Int) = div.all { this % it == 0 }
}