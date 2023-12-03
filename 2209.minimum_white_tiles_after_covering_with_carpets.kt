import kotlin.math.min

class Solution {
  private var f: Array<IntArray>
  private var s: IntArray
  private var n = 0
  private var k = 0
  fun minimumWhiteTiles(floor: String, numCarpets: Int, carpetLen: Int): Int {
    n = floor.length
    f = Array(n) { IntArray(numCarpets + 1) }
    for (e in f) {
      Arrays.fill(e, -1)
    }
    s = IntArray(n + 1)
    for (i in 0 until n) {
      s[i + 1] = s[i] + if (floor[i] == '1') 1 else 0
    }
    k = carpetLen
    return dfs(0, numCarpets)
  }

  private fun dfs(i: Int, j: Int): Int {
    if (i >= n) {
      return 0
    }
    if (j == 0) {
      return s[n] - s[i]
    }
    if (f[i][j] != -1) {
      return f[i][j]
    }
    if (s[i + 1] == s[i]) {
      return dfs(i + 1, j)
    }
    val ans = min((1 + dfs(i + 1, j)).toDouble(), dfs(i + k, j - 1).toDouble()).toInt()
    f[i][j] = ans
    return ans
  }
}
