package fizz_buzz

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

/**
 * Write a function that takes positive integers and outputs their string representation.
 *
 * Your function should comply with the following additional rules:
 *      If the number is a multiple of three, return the string "Fizz".
 *      If the number is a multiple of five, return the string "Buzz".
 *      If the number is a multiple of both three and five, return the string "FizzBuzz".
 */

class FizzBuzzTest {

    @Test
    fun `fizz buzz should be the value when invoked with a number that is not multiple of 3 or 5`() {
        val fizzBuzz = FizzBuzz()

        (1..100).filter { it % 3 != 0 && it % 5 != 0 }.forEach {
            fizzBuzz(it) shouldBe it.toString()
        }
    }


    @Test
    fun `fizz buzz should return Fizz when invoked with any multiple of 3 and not of 5`() {
        val fizzBuzz = FizzBuzz()

        (1..100).filter { it % 3 == 0 && it % 5 != 0 }.forEach {
            fizzBuzz(it) shouldBe "Fizz"
        }
    }

    @Test
    fun `fizz buzz should return Buzz when invoked with any multiple of 5 and not of 3`() {
        val fizzBuzz = FizzBuzz()

        (1..100).filter { it % 3 != 0 && it % 5 == 0 }.forEach {
            fizzBuzz(it) shouldBe "Buzz"
        }
    }

    @Test
    fun `fizz buzz should return FizzBuzz when invoked with any multiple of both 3 and 5`() {
        val fizzBuzz = FizzBuzz()

        (1..100).filter { it % 3 == 0 && it % 5 == 0 }.forEach {
            fizzBuzz(it) shouldBe "FizzBuzz"
        }
    }
}