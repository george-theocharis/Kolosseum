package leap_year

class LeapYear {
    operator fun invoke(year: Int) : Boolean {
        return year % 4 == 0
    }
}