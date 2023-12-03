import kotlin.math.min

class Solution {
  private var n = 0
  private var values: IntArray
  private var f: Array<Array<Int>>
  fun minScoreTriangulation(values: IntArray): Int {
    n = values.size
    this.values = values
    f = Array(n) { arrayOfNulls(n) }
    return dfs(0, n - 1)
  }

  private fun dfs(i: Int, j: Int): Int {
    if (i + 1 == j) {
      return 0
    }
    if (f[i][j] != null) {
      return f[i][j]
    }
    var ans = 1 shl 30
    for (k in i + 1 until j) {
      ans = min(ans.toDouble(), (dfs(i, k) + dfs(k, j) + values[i] * values[k] * values[j]).toDouble())
        .toInt()
    }
    return ans.also { f[i][j] = it }
  }
}
