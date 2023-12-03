import java.util.*

internal object Solution {
  private val WEEK = arrayOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
  fun dayOfTheWeek(day: Int, month: Int, year: Int): String {
    val calendar = Calendar.getInstance()
    calendar[year, month - 1] = day
    return Solution.WEEK.get(calendar[Calendar.DAY_OF_WEEK] - 1)
  }
}
