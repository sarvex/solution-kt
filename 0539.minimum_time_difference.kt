internal class Solution {
  fun findMinDifference(timePoints: List<String>): Int {
    if (timePoints.size() > 24 * 60) {
      return 0
    }
    val mins: List<Int> = ArrayList()
    for (t in timePoints) {
      val time = t.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
      mins.add(time[0].toInt() * 60 + time[1].toInt())
    }
    Collections.sort(mins)
    mins.add(mins[0] + 24 * 60)
    var res = 24 * 60
    for (i in 1 until mins.size()) {
      res = Math.min(res, mins[i] - mins[i - 1])
    }
    return res
  }
}
