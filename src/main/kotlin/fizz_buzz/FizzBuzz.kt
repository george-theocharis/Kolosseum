package fizz_buzz

class FizzBuzz {
    operator fun invoke(number: Int): String {
        if (number % 3 == 0) return "Fizz"
        if (number % 5 == 0) return "Buzz"
        return number.toString()
    }
}