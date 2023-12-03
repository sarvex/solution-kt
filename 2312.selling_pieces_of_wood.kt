import kotlin.math.max

class Solution {
  private var memo: Array<LongArray>
  private var d: Array<IntArray>
  fun sellingWood(m: Int, n: Int, prices: Array<IntArray>): Long {
    d = Array(m + 1) { IntArray(n + 1) }
    memo = Array(m + 1) { LongArray(n + 1) }
    for (e in memo) {
      Arrays.fill(e, -1)
    }
    for (p in prices) {
      d[p[0]][p[1]] = p[2]
    }
    return dfs(m, n)
  }

  private fun dfs(m: Int, n: Int): Long {
    if (memo[m][n] != -1L) {
      return memo[m][n]
    }
    var ans = d[m][n].toLong()
    for (i in 1 until m / 2 + 1) {
      ans = max(ans.toDouble(), (dfs(i, n) + dfs(m - i, n)).toDouble()).toLong()
    }
    for (i in 1 until n / 2 + 1) {
      ans = max(ans.toDouble(), (dfs(m, i) + dfs(m, n - i)).toDouble()).toLong()
    }
    memo[m][n] = ans
    return ans
  }
}
