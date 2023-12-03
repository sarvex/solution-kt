import kotlin.math.max
import kotlin.math.min

class Solution {
  private var cost: IntArray
  private var n = 0
  private var ans = 0
  fun minIncrements(n: Int, cost: IntArray): Int {
    this.n = n
    this.cost = cost
    dfs(1)
    return ans
  }

  private fun dfs(i: Int): Int {
    if (i shl 1 > n) {
      return cost[i - 1]
    }
    val l = dfs(i shl 1)
    val r = dfs(i shl 1 or 1)
    (ans += max(l.toDouble(), r.toDouble()) - min(l.toDouble(), r.toDouble())).toInt()
    return (cost[i - 1] + max(l.toDouble(), r.toDouble())).toInt()
  }
}
