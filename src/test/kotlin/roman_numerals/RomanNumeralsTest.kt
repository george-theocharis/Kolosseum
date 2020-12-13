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

    @Test
    fun `converting 6 should be "VI"`() {

        convert(6) shouldBe "VI"
    }

    @Test
    fun `converting 7 should be "VII"`() {

        convert(7) shouldBe "VII"
    }

    @Test
    fun `converting 8 should be "VIII"`() {

        convert(8) shouldBe "VIII"
    }

    @Test
    fun `converting 9 should be "IX"`() {

        convert(9) shouldBe "IX"
    }

    @Test
    fun `converting 10 to 13 should be "X, XI, XII, XIII"`() {

        (10..13).map { convert(it) } shouldBe listOf("X", "XI", "XII", "XIII")
    }
}