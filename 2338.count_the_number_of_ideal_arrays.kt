class Solution {
  private var f: Array<IntArray>
  private var c: Array<IntArray>
  private var n = 0
  private var m = 0
  fun idealArrays(n: Int, maxValue: Int): Int {
    this.n = n
    m = maxValue
    f = Array(maxValue + 1) { IntArray(16) }
    for (row in f) {
      Arrays.fill(row, -1)
    }
    c = Array(n) { IntArray(16) }
    for (i in 0 until n) {
      var j = 0
      while (j <= i && j < 16) {
        c[i][j] = if (j == 0) 1 else (c[i - 1][j] + c[i - 1][j - 1]) % Solution.Companion.MOD
        ++j
      }
    }
    var ans = 0
    for (i in 1..m) {
      ans = (ans + dfs(i, 1)) % Solution.Companion.MOD
    }
    return ans
  }

  private fun dfs(i: Int, cnt: Int): Int {
    if (f[i][cnt] != -1) {
      return f[i][cnt]
    }
    var res = c[n - 1][cnt - 1]
    if (cnt < n) {
      var k = 2
      while (k * i <= m) {
        res = (res + dfs(k * i, cnt + 1)) % Solution.Companion.MOD
        ++k
      }
    }
    f[i][cnt] = res
    return res
  }

  companion object {
    private const val MOD = 1e9.toInt() + 7
  }
}
