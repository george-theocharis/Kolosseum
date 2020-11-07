package fizz_buzz

class FizzBuzz {
    operator fun invoke(number: Int): String {
        if (number == 3) return "Fizz"
        return number.toString()
    }
}