import kotlin.math.max

internal class Solution {
  private var f: Array<Array<IntArray>>
  private var b: IntArray
  fun removeBoxes(boxes: IntArray): Int {
    b = boxes
    val n = b.size
    f = Array(n) { Array(n) { IntArray(n) } }
    return dfs(0, n - 1, 0)
  }

  private fun dfs(i: Int, j: Int, k: Int): Int {
    var j = j
    var k = k
    if (i > j) {
      return 0
    }
    while (i < j && b[j] == b[j - 1]) {
      --j
      ++k
    }
    if (f[i][j][k] > 0) {
      return f[i][j][k]
    }
    var ans = dfs(i, j - 1, 0) + (k + 1) * (k + 1)
    for (h in i until j) {
      if (b[h] == b[j]) {
        ans = max(ans.toDouble(), (dfs(h + 1, j - 1, 0) + dfs(i, h, k + 1)).toDouble()).toInt()
      }
    }
    f[i][j][k] = ans
    return ans
  }
}
