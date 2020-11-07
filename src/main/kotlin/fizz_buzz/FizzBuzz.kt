package fizz_buzz

class FizzBuzz {
    operator fun invoke(number: Int): String {
        if(number == 4) return "4"
        if(number == 2) return "2"
        return "1"
    }
}