import kotlin.math.min

internal class Solution {
  fun minDistance(word1: String, word2: String): Int {
    val m = word1.length
    val n = word2.length
    val f = Array(m + 1) { IntArray(n + 1) }
    for (j in 1..n) {
      f[0][j] = j
    }
    for (i in 1..m) {
      f[i][0] = i
      for (j in 1..n) {
        if (word1[i - 1] == word2[j - 1]) {
          f[i][j] = f[i - 1][j - 1]
        } else {
          f[i][j] = (min(
            f[i - 1][j].toDouble(),
            min(f[i][j - 1].toDouble(), f[i - 1][j - 1].toDouble())
          ) + 1).toInt()
        }
      }
    }
    return f[m][n]
  }
}
