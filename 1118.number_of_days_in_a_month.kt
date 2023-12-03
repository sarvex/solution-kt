internal class Solution {
  fun numberOfDays(year: Int, month: Int): Int {
    val leap = year % 4 == 0 && year % 100 != 0 || year % 400 == 0
    val days = intArrayOf(0, 31, if (leap) 29 else 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    return days[month]
  }
}
