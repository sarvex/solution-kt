import kotlin.math.max

class Solution {
  private var n = 0
  private var s: IntArray
  private var stoneValue: IntArray
  private var f: Array<Array<Int>>
  fun stoneGameV(stoneValue: IntArray): Int {
    n = stoneValue.size
    this.stoneValue = stoneValue
    s = IntArray(n + 1)
    for (i in 1..n) {
      s[i] = s[i - 1] + stoneValue[i - 1]
    }
    f = Array(n) { arrayOfNulls(n) }
    return dfs(0, n - 1)
  }

  private fun dfs(i: Int, j: Int): Int {
    if (i == j) {
      return 0
    }
    if (f[i][j] != null) {
      return f[i][j]
    }
    var ans = 0
    var a = 0
    for (k in i until j) {
      a += stoneValue[k]
      val b = s[j + 1] - s[i] - a
      ans = if (a < b) {
        if (ans >= a * 2) {
          continue
        }
        max(ans.toDouble(), (a + dfs(i, k)).toDouble()).toInt()
      } else if (a > b) {
        if (ans >= b * 2) {
          break
        }
        max(ans.toDouble(), (b + dfs(k + 1, j)).toDouble()).toInt()
      } else {
        max(ans.toDouble(), max((a + dfs(i, k)).toDouble(), (b + dfs(k + 1, j)).toDouble()))
          .toInt()
      }
    }
    return ans.also { f[i][j] = it }
  }
}
