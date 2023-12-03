import kotlin.math.max

internal class Solution {
  private var rides: Array<IntArray>
  private var f: LongArray
  private var m = 0
  fun maxTaxiEarnings(n: Int, rides: Array<IntArray>): Long {
    m = rides.size
    f = LongArray(m)
    Arrays.sort(rides) { a, b -> a.get(0) - b.get(0) }
    this.rides = rides
    return dfs(0)
  }

  private fun dfs(i: Int): Long {
    if (i >= m) {
      return 0
    }
    if (f[i] != 0L) {
      return f[i]
    }
    val s = rides[i][0]
    val e = rides[i][1]
    val t = rides[i][2]
    val j = search(rides, e, i + 1)
    val ans = max(dfs(i + 1).toDouble(), (dfs(j) + e - s + t).toDouble()).toLong()
    f[i] = ans
    return ans
  }

  private fun search(rides: Array<IntArray>, x: Int, i: Int): Int {
    var left = i
    var right = m
    while (left < right) {
      val mid = left + right shr 1
      if (rides[mid][0] >= x) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }
}
