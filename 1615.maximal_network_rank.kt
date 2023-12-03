import kotlin.math.max

class Solution {
  fun maximalNetworkRank(n: Int, roads: Array<IntArray>): Int {
    val g = Array(n) { IntArray(n) }
    val cnt = IntArray(n)
    for (r in roads) {
      val a = r[0]
      val b = r[1]
      g[a][b] = 1
      g[b][a] = 1
      ++cnt[a]
      ++cnt[b]
    }
    var ans = 0
    for (a in 0 until n) {
      for (b in a + 1 until n) {
        ans = max(ans.toDouble(), (cnt[a] + cnt[b] - g[a][b]).toDouble()).toInt()
      }
    }
    return ans
  }
}
