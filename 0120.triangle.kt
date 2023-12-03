import kotlin.math.min

internal class Solution {
  fun minimumTotal(triangle: List<List<Int>>): Int {
    val n: Int = triangle.size()
    val dp = IntArray(n + 1)
    for (i in n - 1 downTo 0) {
      for (j in 0..i) {
        dp[j] = (min(dp[j].toDouble(), dp[j + 1].toDouble()) + triangle[i][j]).toInt()
      }
    }
    return dp[0]
  }
}
