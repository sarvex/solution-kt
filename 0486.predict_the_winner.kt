import kotlin.math.max

internal class Solution {
  fun PredictTheWinner(nums: IntArray): Boolean {
    val n = nums.size
    val f = Array(n) { IntArray(n) }
    for (i in 0 until n) {
      f[i][i] = nums[i]
    }
    for (i in n - 2 downTo 0) {
      for (j in i + 1 until n) {
        f[i][j] = max((nums[i] - f[i + 1][j]).toDouble(), (nums[j] - f[i][j - 1]).toDouble())
          .toInt()
      }
    }
    return f[0][n - 1] >= 0
  }
}
