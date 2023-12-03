import kotlin.math.abs

class Solution {
  fun daysBetweenDates(date1: String, date2: String): Int {
    return abs((calcDays(date1) - calcDays(date2)).toDouble()).toInt()
  }

  private fun isLeapYear(year: Int): Boolean {
    return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)
  }

  private fun daysInMonth(year: Int, month: Int): Int {
    val days = intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    days[1] += if (isLeapYear(year)) 1 else 0
    return days[month - 1]
  }

  private fun calcDays(date: String): Int {
    val year = date.substring(0, 4).toInt()
    val month = date.substring(5, 7).toInt()
    val day = date.substring(8).toInt()
    var days = 0
    for (y in 1971 until year) {
      days += if (isLeapYear(y)) 366 else 365
    }
    for (m in 1 until month) {
      days += daysInMonth(year, m)
    }
    days += day
    return days
  }
}
