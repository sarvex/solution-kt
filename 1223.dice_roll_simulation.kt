class Solution {
  private var f: Array<Array<Array<Int>>>
  private var rollMax: IntArray
  fun dieSimulator(n: Int, rollMax: IntArray): Int {
    f = Array(n) { Array<Array<Int?>>(7) { arrayOfNulls(16) } }
    this.rollMax = rollMax
    return dfs(0, 0, 0)
  }

  private fun dfs(i: Int, j: Int, x: Int): Int {
    if (i >= f.size) {
      return 1
    }
    if (f[i][j][x] != null) {
      return f[i][j][x]
    }
    var ans: Long = 0
    for (k in 1..6) {
      if (k != j) {
        ans += dfs(i + 1, k, 1).toLong()
      } else if (x < rollMax[j - 1]) {
        ans += dfs(i + 1, j, x + 1).toLong()
      }
    }
    ans %= 1000000007
    return ans.toInt().also { f[i][j][x] = it }
  }
}
