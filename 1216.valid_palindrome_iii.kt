import kotlin.math.max

internal class Solution {
  fun isValidPalindrome(s: String, k: Int): Boolean {
    val n = s.length
    val f = Array(n) { IntArray(n) }
    for (i in 0 until n) {
      f[i][i] = 1
    }
    for (i in n - 2 downTo 0) {
      for (j in i + 1 until n) {
        if (s[i] == s[j]) {
          f[i][j] = f[i + 1][j - 1] + 2
        } else {
          f[i][j] = max(f[i + 1][j].toDouble(), f[i][j - 1].toDouble()).toInt()
        }
        if (f[i][j] + k >= n) {
          return true
        }
      }
    }
    return false
  }
}
