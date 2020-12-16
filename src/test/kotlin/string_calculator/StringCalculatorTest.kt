package string_calculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StringCalculatorTest {

    private val calculator = StringCalculator()

    @Test
    fun `should return 0 when adding an empty string`() {
        val result = calculator.add("")

        result shouldBe 0
    }

    @Test
    fun `should return number when adding a string including a single number`() {
        val result = calculator.add("4")

        result shouldBe 4
    }

    @Test
    fun `should return the sum when passing a string with two numbers comma separated`() {
        val result = calculator.add("1,2")

        result shouldBe 3
    }

    @Test
    fun `should throw a malformed exception when passing a string with characters and no numbers`() {
        assertThrows<BadInputFormatException> {
            calculator.add("c")
        }
    }

    @Test
    fun `should throw a malformed exception when passing a string with characters and a number`() {
        assertThrows<BadInputFormatException> {
            calculator.add("1,k")
        }
    }

}