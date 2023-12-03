class Solution {
  private val idx: List<Int> = ArrayList()
  private var f: Array<Array<Int>>
  private var x = 0
  fun minOperations(s1: String, s2: String, x: Int): Int {
    val n = s1.length
    for (i in 0 until n) {
      if (s1[i] != s2[i]) {
        idx.add(i)
      }
    }
    val m: Int = idx.size()
    if (m % 2 == 1) {
      return -1
    }
    this.x = x
    f = Array(m) { arrayOfNulls(m) }
    return dfs(0, m - 1)
  }

  private fun dfs(i: Int, j: Int): Int {
    if (i > j) {
      return 0
    }
    if (f[i][j] != null) {
      return f[i][j]
    }
    f[i][j] = dfs(i + 1, j - 1) + x
    f[i][j] = Math.min(f[i][j], dfs(i + 2, j) + idx[i + 1] - idx[i])
    f[i][j] = Math.min(f[i][j], dfs(i, j - 2) + idx[j] - idx[j - 1])
    return f[i][j]
  }
}
