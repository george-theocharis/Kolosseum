package roman_numerals

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RomanNumeralsTest {

    @Test
    fun `converting 1 should be "I"`() {

        convert(1) shouldBe "I"
    }
}