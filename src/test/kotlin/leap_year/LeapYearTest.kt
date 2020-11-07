package leap_year

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

/**
 * Implement a method that checks if a year is a leap year.
 *
 * All the following rules must be satisfied:
 *
 *      A year is not a leap year if not divisible by 4
 *      A year is a leap year if divisible by 4
 *      A year is a leap year if divisible by 400
 *      A year is not a leap year if divisible by 100 but not by 400
 *
 *      Examples:
 *      1997 is not a leap year (not divisible by 4)
 *      1996 is a leap year (divisible by 4)
 *      1600 is a leap year (divisible by 400)
 *      1800 is not a leap year (divisible by 4, divisible by 100, NOT divisible by 400)
 *
 *      The method should return true if a year is a leap year, and false if it is not.
 */

class LeapYearTest {

    @Test
    fun `a year is not a leap year if not divisible by 4`() {
        val leapYear = LeapYear()

        (1000..2020)
            .filter { year -> year % 4 != 0 }
            .forEach { year -> leapYear(year) shouldBe false }
    }

    @Test
    fun `a year is a leap year if divisible by 4`() {
        val leapYear = LeapYear()

        leapYear(1996) shouldBe true
    }

    @Test
    fun `a year is a leap year if divisible by 400`() {
        val leapYear = LeapYear()

        leapYear(1600) shouldBe true
    }

    @Test
    fun `a year is not a leap year if divisible by 100 but not by 400`() {
        val leapYear = LeapYear()

        leapYear(1800) shouldBe false
    }

}