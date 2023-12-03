import kotlin.math.max

class Solution {
  private var s: IntArray
  private var f: Array<Array<Int>>
  fun stoneGameVII(stones: IntArray): Int {
    val n = stones.size
    s = IntArray(n + 1)
    f = Array(n) { arrayOfNulls(n) }
    for (i in 0 until n) {
      s[i + 1] = s[i] + stones[i]
    }
    return dfs(0, n - 1)
  }

  private fun dfs(i: Int, j: Int): Int {
    if (i > j) {
      return 0
    }
    if (f[i][j] != null) {
      return f[i][j]
    }
    val a = s[j + 1] - s[i + 1] - dfs(i + 1, j)
    val b = s[j] - s[i] - dfs(i, j - 1)
    return max(a.toDouble(), b.toDouble()).also { f[i][j] = it.toInt() }.toInt().toInt()
  }
}
