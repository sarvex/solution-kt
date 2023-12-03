import java.util.*

internal class MyCalendar {
  private val tm = TreeMap<Int, Int>()
  fun book(start: Int, end: Int): Boolean {
    var ent = tm.floorEntry(start)
    if (ent != null && ent.value > start) {
      return false
    }
    ent = tm.ceilingEntry(start)
    if (ent != null && ent.key < end) {
      return false
    }
    tm[start] = end
    return true
  }
}
