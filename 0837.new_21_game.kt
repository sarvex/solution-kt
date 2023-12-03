import kotlin.math.min

internal class Solution {
  private var f: DoubleArray
  private var n = 0
  private var k = 0
  private var maxPts = 0
  fun new21Game(n: Int, k: Int, maxPts: Int): Double {
    f = DoubleArray(k)
    this.n = n
    this.k = k
    this.maxPts = maxPts
    return dfs(0)
  }

  private fun dfs(i: Int): Double {
    if (i >= k) {
      return if (i <= n) 1 else 0
    }
    if (i == k - 1) {
      return min((n - k + 1).toDouble(), maxPts.toDouble()) * 1.0 / maxPts
    }
    return if (f[i] != 0.0) {
      f[i]
    } else (dfs(i + 1) + (dfs(i + 1) - dfs(i + maxPts + 1)) / maxPts).also { f[i] = it }
  }
}
