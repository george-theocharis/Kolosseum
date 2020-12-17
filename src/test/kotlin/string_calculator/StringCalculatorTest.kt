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

    @Test
    fun `should add an arbitrary number of integers`() {
        val result = calculator.add("1,2,3,4,5,6,7,8,9")

        result shouldBe 45
    }

    @Test
    fun `should consider new line as a separator too`() {
        val result = calculator.add("1\n2,3")

        result shouldBe 6
    }

    @Test
    fun `should be able to add custom separator`() {
        val result = calculator.add("//;\n1;2")

        result shouldBe 3
    }

    @Test
    fun `should throw negatives not allowed exception when adding negative numbers`() {
        assertThrows<NegativesNotAllowedException> { calculator.add("1,-2") }
    }

    @Test
    fun `should throw negatives not allowed exception with all the negative numbers as error message given multiple negative numbers`() {
        try {
            calculator.add("1,-2,-3")
        } catch (exception: NegativesNotAllowedException){
            exception.message shouldBe "-2 -3"
        }
    }

}