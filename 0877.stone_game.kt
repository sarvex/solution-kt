import kotlin.math.max

internal class Solution {
  fun stoneGame(piles: IntArray): Boolean {
    val n = piles.size
    val f = Array(n) { IntArray(n) }
    for (i in 0 until n) {
      f[i][i] = piles[i]
    }
    for (i in n - 2 downTo 0) {
      for (j in i + 1 until n) {
        f[i][j] = max((piles[i] - f[i + 1][j]).toDouble(), (piles[j] - f[i][j - 1]).toDouble())
          .toInt()
      }
    }
    return f[0][n - 1] > 0
  }
}
