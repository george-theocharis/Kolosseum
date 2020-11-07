package fizz_buzz

class FizzBuzz {
    operator fun invoke(number: Int) = when {
        number % 3 == 0 && number % 5 == 0 -> "FizzBuzz"
        number % 3 == 0 -> "Fizz"
        number % 5 == 0 -> "Buzz"
        else -> number.toString()
    }
}