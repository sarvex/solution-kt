import kotlin.math.max

class Solution {
  fun maximumScore(nums: IntArray, multipliers: IntArray): Int {
    val inf = 1 shl 30
    val n = nums.size
    val m = multipliers.size
    val f = Array(m + 1) { IntArray(m + 1) }
    for (i in 0..m) {
      Arrays.fill(f[i], -inf)
    }
    f[0][0] = 0
    var ans = -inf
    for (i in 0..m) {
      for (j in 0..m - i) {
        val k = i + j - 1
        if (i > 0) {
          f[i][j] = max(f[i][j].toDouble(), (f[i - 1][j] + multipliers[k] * nums[i - 1]).toDouble())
            .toInt()
        }
        if (j > 0) {
          f[i][j] = max(f[i][j].toDouble(), (f[i][j - 1] + multipliers[k] * nums[n - j]).toDouble())
            .toInt()
        }
        if (i + j == m) {
          ans = max(ans.toDouble(), f[i][j].toDouble()).toInt()
        }
      }
    }
    return ans
  }
}
