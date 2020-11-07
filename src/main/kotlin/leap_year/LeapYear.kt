package leap_year

class LeapYear {
    operator fun invoke(year: Int): Boolean {
        if(year % 100 == 0 && year % 400 != 0) return false
        return year % 4 == 0
    }
}