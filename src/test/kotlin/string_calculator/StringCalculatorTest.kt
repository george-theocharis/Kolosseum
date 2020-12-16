package string_calculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

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

}