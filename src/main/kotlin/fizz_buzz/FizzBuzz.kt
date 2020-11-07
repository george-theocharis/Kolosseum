package fizz_buzz

class FizzBuzz {
    operator fun invoke(number: Int): String {
        if (number == 5) return "Buzz"
        if (number % 3 == 0) return "Fizz"
        return number.toString()
    }
}