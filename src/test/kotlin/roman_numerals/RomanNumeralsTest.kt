package roman_numerals

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RomanNumeralsTest {

    @Test
    fun `converting 1 to 3 should be "I", "II", "III"`() {
        (1..3).map { convert(it) } shouldBe listOf("I", "II", "III")
    }

    @Test
    fun `converting 4 should be "IV"`() {
        convert(4) shouldBe "IV"
    }

    @Test
    fun `converting 5 should be "V"`() {
        (5..8).map { convert(it) } shouldBe listOf("V", "VI", "VII", "VIII")
    }

    @Test
    fun `converting 9 should be "IX"`() {
        convert(9) shouldBe "IX"
    }

    @Test
    fun `converting 10 to 13 should be "X, XI, XII, XIII"`() {
        (10..13).map { convert(it) } shouldBe listOf("X", "XI", "XII", "XIII")
    }

    @Test
    fun `converting 14 should be "XIV"`() {
        convert(14) shouldBe "XIV"
    }

    @Test
    fun `converting 15 to 18 should be "XV, XVI, XVII, XVIII"`() {
        (15..18).map { convert(it) } shouldBe listOf("XV", "XVI", "XVII", "XVIII")
    }

    @Test
    fun `converting 19 should be "XIX"`() {
        convert(19) shouldBe "XIX"
    }

    @Test
    fun `converting 20 should be "XX"`() {
        convert(20) shouldBe "XX"
    }

    @Test
    fun `converting 30 should be "XXX"`() {
        convert(30) shouldBe "XXX"
    }

    @Test
    fun `converting 40 should be "XL"`() {
        convert(40) shouldBe "XL"
    }

    @Test
    fun `converting 50 should be "L"`() {
        convert(50) shouldBe "L"
    }
}