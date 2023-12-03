import kotlin.math.max

class Solution {
  private var s: IntArray
  private var f: Array<Array<Int>>
  private var n = 0
  fun stoneGameII(piles: IntArray): Int {
    n = piles.size
    s = IntArray(n + 1)
    f = Array(n) { arrayOfNulls(n + 1) }
    for (i in 0 until n) {
      s[i + 1] = s[i] + piles[i]
    }
    return dfs(0, 1)
  }

  private fun dfs(i: Int, m: Int): Int {
    if (m * 2 >= n - i) {
      return s[n] - s[i]
    }
    if (f[i][m] != null) {
      return f[i][m]
    }
    var res = 0
    for (x in 1..m * 2) {
      res = max(
        res.toDouble(), (s[n] - s[i] - dfs(
          i + x, max(m.toDouble(), x.toDouble())
            .toInt()
        )).toDouble()
      ).toInt()
    }
    return res.also { f[i][m] = it }
  }
}
