import kotlin.math.max

class Solution {
  fun longestPalindrome(word1: String, word2: String): Int {
    val s = word1 + word2
    val n = s.length
    val f = Array(n) { IntArray(n) }
    for (i in 0 until n) {
      f[i][i] = 1
    }
    var ans = 0
    for (i in n - 2 downTo 0) {
      for (j in i + 1 until n) {
        if (s[i] == s[j]) {
          f[i][j] = f[i + 1][j - 1] + 2
          if (i < word1.length && j >= word1.length) {
            ans = max(ans.toDouble(), f[i][j].toDouble()).toInt()
          }
        } else {
          f[i][j] = max(f[i + 1][j].toDouble(), f[i][j - 1].toDouble()).toInt()
        }
      }
    }
    return ans
  }
}
