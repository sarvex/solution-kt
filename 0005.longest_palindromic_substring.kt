import java.util.*

internal class Solution {
  fun longestPalindrome(s: String): String {
    val n = s.length
    val f = Array(n) { BooleanArray(n) }
    for (g in f) {
      Arrays.fill(g, true)
    }
    var k = 0
    var mx = 1
    for (i in n - 2 downTo 0) {
      for (j in i + 1 until n) {
        f[i][j] = false
        if (s[i] == s[j]) {
          f[i][j] = f[i + 1][j - 1]
          if (f[i][j] && mx < j - i + 1) {
            mx = j - i + 1
            k = i
          }
        }
      }
    }
    return s.substring(k, k + mx)
  }
}
