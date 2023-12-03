import kotlin.math.abs

class Solution {
  private var f: Array<Array<Int>>
  private val mod = 1e9.toInt() + 7
  fun numberOfWays(startPos: Int, endPos: Int, k: Int): Int {
    f = Array(k + 1) { arrayOfNulls(k + 1) }
    return dfs(abs((startPos - endPos).toDouble()).toInt(), k)
  }

  private fun dfs(i: Int, j: Int): Int {
    if (i > j || j < 0) {
      return 0
    }
    if (j == 0) {
      return if (i == 0) 1 else 0
    }
    if (f[i][j] != null) {
      return f[i][j]
    }
    var ans = dfs(i + 1, j - 1) + dfs(abs((i - 1).toDouble()).toInt(), j - 1)
    ans %= mod
    return ans.also { f[i][j] = it }
  }
}
