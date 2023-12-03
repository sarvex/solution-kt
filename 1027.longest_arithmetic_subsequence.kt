import kotlin.math.max

internal class Solution {
  fun longestArithSeqLength(nums: IntArray): Int {
    val n = nums.size
    var ans = 0
    val f = Array(n) { IntArray(1001) }
    for (i in 1 until n) {
      for (k in 0 until i) {
        val j = nums[i] - nums[k] + 500
        f[i][j] = max(f[i][j].toDouble(), (f[k][j] + 1).toDouble()).toInt()
        ans = max(ans.toDouble(), f[i][j].toDouble()).toInt()
      }
    }
    return ans + 1
  }
}
