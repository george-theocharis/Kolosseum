package roman_numerals

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RomanNumeralsTest {

    @Test
    fun `converting 1 should be "I"`() {

        convert(1) shouldBe "I"
    }

    @Test
    fun `converting 2 should be "II"`() {

        convert(2) shouldBe "II"
    }

    @Test
    fun `converting 3 should be "III"`() {

        convert(3) shouldBe "III"
    }

    @Test
    fun `converting 4 should be "IV"`() {

        convert(4) shouldBe "IV"
    }

    @Test
    fun `converting 5 should be "V"`() {

        convert(5) shouldBe "V"
    }
}