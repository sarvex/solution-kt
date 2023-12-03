class Solution {
  private var m = 0
  private var n = 0
  private var target: String? = null
  private var f: Array<Array<Int>>
  private var cnt: Array<IntArray>
  private val mod = 1e9.toInt() + 7
  fun numWays(words: Array<String>, target: String): Int {
    m = target.length
    n = words[0].length
    f = Array(m) { arrayOfNulls(n) }
    this.target = target
    cnt = Array(n) { IntArray(26) }
    for (w in words) {
      for (j in 0 until n) {
        cnt[j][w[j].code - 'a'.code]++
      }
    }
    return dfs(0, 0)
  }

  private fun dfs(i: Int, j: Int): Int {
    if (i >= m) {
      return 1
    }
    if (j >= n) {
      return 0
    }
    if (f[i][j] != null) {
      return f[i][j]
    }
    var ans = dfs(i, j + 1).toLong()
    ans += 1L * dfs(i + 1, j + 1) * cnt[j][target!![i].code - 'a'.code]
    ans %= mod.toLong()
    return ans.toInt().also { f[i][j] = it }
  }
}
