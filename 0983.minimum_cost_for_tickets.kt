import kotlin.math.min

class Solution {
  private var costs: IntArray
  private var days: IntArray
  private var f: IntArray
  private var n = 0
  fun mincostTickets(days: IntArray, costs: IntArray): Int {
    n = days.size
    f = IntArray(n)
    this.costs = costs
    this.days = days
    Arrays.fill(f, -1)
    return dfs(0)
  }

  private fun dfs(i: Int): Int {
    if (i >= n) {
      return 0
    }
    if (f[i] != -1) {
      return f[i]
    }
    var res = Int.MAX_VALUE
    for (k in 0..2) {
      val j = lowerBound(days, days[i] + Solution.Companion.T.get(k))
      res = min(res.toDouble(), (costs[k] + dfs(j)).toDouble()).toInt()
    }
    f[i] = res
    return res
  }

  private fun lowerBound(days: IntArray, x: Int): Int {
    var left = 0
    var right = days.size
    while (left < right) {
      val mid = left + right shr 1
      if (days[mid] >= x) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }

  companion object {
    private val T = intArrayOf(1, 7, 30)
  }
}
