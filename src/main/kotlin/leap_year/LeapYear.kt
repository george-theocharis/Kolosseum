package leap_year

class LeapYear {
    operator fun invoke(year: Int) = if (year % 100 == 0 && year % 400 != 0) false else year % 4 == 0
}