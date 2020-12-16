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

}