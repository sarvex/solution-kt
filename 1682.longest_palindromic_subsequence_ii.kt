import kotlin.math.max

class Solution {
  private var f: Array<Array<IntArray>>
  private var s: String? = null
  fun longestPalindromeSubseq(s: String): Int {
    val n = s.length
    this.s = s
    f = Array(n) { Array(n) { IntArray(27) } }
    for (a in f) {
      for (b in a) {
        Arrays.fill(b, -1)
      }
    }
    return dfs(0, n - 1, 26)
  }

  private fun dfs(i: Int, j: Int, x: Int): Int {
    if (i >= j) {
      return 0
    }
    if (f[i][j][x] != -1) {
      return f[i][j][x]
    }
    var ans = 0
    ans = if (s!![i] == s!![j] && s!![i].code - 'a'.code != x) {
      dfs(i + 1, j - 1, s!![i].code - 'a'.code) + 2
    } else {
      max(dfs(i + 1, j, x).toDouble(), dfs(i, j - 1, x).toDouble()).toInt()
    }
    f[i][j][x] = ans
    return ans
  }
}
