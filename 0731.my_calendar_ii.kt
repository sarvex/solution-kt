import java.util.*

internal class MyCalendarTwo {
  private val tm: Map<Int, Int> = TreeMap()
  fun book(start: Int, end: Int): Boolean {
    tm.put(start, (tm[start] ?: 0) + 1)
    tm.put(end, (tm[end] ?: 0) - 1)
    var s = 0
    for (v in tm.values()) {
      s += v
      if (s > 2) {
        tm.put(start, tm[start]!! - 1)
        tm.put(end, tm[end]!! + 1)
        return false
      }
    }
    return true
  }
}
