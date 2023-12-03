import kotlin.math.max

internal class Solution {
  fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
    val f = Array(m + 1) { IntArray(n + 1) }
    for (s in strs) {
      val cnt = count(s)
      for (i in m downTo cnt[0]) {
        for (j in n downTo cnt[1]) {
          f[i][j] = max(f[i][j].toDouble(), (f[i - cnt[0]][j - cnt[1]] + 1).toDouble())
            .toInt()
        }
      }
    }
    return f[m][n]
  }

  private fun count(s: String): IntArray {
    val cnt = IntArray(2)
    for (i in 0 until s.length) {
      ++cnt[s[i].code - '0'.code]
    }
    return cnt
  }
}
