import kotlin.math.max

class Solution {
  private val days = intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
  fun countDaysTogether(
    arriveAlice: String, leaveAlice: String, arriveBob: String, leaveBob: String?
  ): Int {
    val a = if (arriveAlice.compareTo(arriveBob) < 0) arriveBob else arriveAlice
    val b = if (leaveAlice.compareTo(leaveBob!!) < 0) leaveAlice else leaveBob
    val x = f(a)
    val y = f(b)
    return max((y - x + 1).toDouble(), 0.0).toInt()
  }

  private fun f(s: String): Int {
    val i = s.substring(0, 2).toInt() - 1
    var res = 0
    for (j in 0 until i) {
      res += days[j]
    }
    res += s.substring(3).toInt()
    return res
  }
}
