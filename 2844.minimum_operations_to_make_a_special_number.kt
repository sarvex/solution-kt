import kotlin.math.min

class Solution {
  private var f: Array<Array<Int>>
  private var num: String? = null
  private var n = 0
  fun minimumOperations(num: String): Int {
    n = num.length
    this.num = num
    f = Array(n) { arrayOfNulls(25) }
    return dfs(0, 0)
  }

  private fun dfs(i: Int, k: Int): Int {
    if (i == n) {
      return if (k == 0) 0 else n
    }
    if (f[i][k] != null) {
      return f[i][k]
    }
    f[i][k] = dfs(i + 1, k) + 1
    f[i][k] = min(f[i][k].toDouble(), dfs(i + 1, (k * 10 + num!![i].code - '0'.code) % 25).toDouble())
      .toInt()
    return f[i][k]
  }
}
