import kotlin.math.max

internal class Solution {
  private var f: Array<IntArray>
  fun superEggDrop(k: Int, n: Int): Int {
    f = Array(n + 1) { IntArray(k + 1) }
    return dfs(n, k)
  }

  private fun dfs(i: Int, j: Int): Int {
    if (i < 1) {
      return 0
    }
    if (j == 1) {
      return i
    }
    if (f[i][j] != 0) {
      return f[i][j]
    }
    var l = 1
    var r = i
    while (l < r) {
      val mid = l + r + 1 shr 1
      val a = dfs(mid - 1, j - 1)
      val b = dfs(i - mid, j)
      if (a <= b) {
        l = mid
      } else {
        r = mid - 1
      }
    }
    return (max(dfs(l - 1, j - 1).toDouble(), dfs(i - l, j).toDouble()) + 1).also {
      f[i][j] = it.toInt()
    }.toInt().toInt()
  }
}
