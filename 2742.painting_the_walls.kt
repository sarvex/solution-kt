import kotlin.math.min

class Solution {
  private var n = 0
  private var cost: IntArray
  private var time: IntArray
  private var f: Array<Array<Int>>
  fun paintWalls(cost: IntArray, time: IntArray): Int {
    n = cost.size
    this.cost = cost
    this.time = time
    f = Array(n) { arrayOfNulls(n shl 1 or 1) }
    return dfs(0, n)
  }

  private fun dfs(i: Int, j: Int): Int {
    if (n - i <= j - n) {
      return 0
    }
    if (i >= n) {
      return 1 shl 30
    }
    if (f[i][j] == null) {
      f[i][j] = min((dfs(i + 1, j + time[i]) + cost[i]).toDouble(), dfs(i + 1, j - 1).toDouble())
        .toInt()
    }
    return f[i][j]
  }
}
