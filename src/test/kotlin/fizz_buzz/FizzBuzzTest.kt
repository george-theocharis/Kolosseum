package fizz_buzz

import io.kotest.matchers.should
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
    fun `fizz buzz should return 1 when invoked with 1`() {
        val fizzBuzz = FizzBuzz()

        fizzBuzz(1) shouldBe "1"
    }

    @Test
    fun `fizz buzz should return 2 when invoked with 2`() {
        val fizzBuzz = FizzBuzz()

        fizzBuzz(2) shouldBe "2"
    }

    @Test
    fun `fizz buzz should return 4 when invoked with 4`() {
        val fizzBuzz = FizzBuzz()

        fizzBuzz(4) shouldBe "4"
    }

    @Test
    fun `fizz buzz should return Fizz when invoked with 3`() {
        val fizzBuzz = FizzBuzz()

        fizzBuzz(3) shouldBe "Fizz"
    }

    @Test
    fun `fizz buzz should return Fizz when invoked with any multiple of 3`() {
        val fizzBuzz = FizzBuzz()

        fizzBuzz(6) shouldBe "Fizz"
    }

}