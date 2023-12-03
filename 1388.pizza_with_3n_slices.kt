import kotlin.math.max

class Solution {
  private var n = 0
  fun maxSizeSlices(slices: IntArray): Int {
    n = slices.size / 3
    val nums = IntArray(slices.size - 1)
    System.arraycopy(slices, 1, nums, 0, nums.size)
    val a = g(nums)
    System.arraycopy(slices, 0, nums, 0, nums.size)
    val b = g(nums)
    return max(a.toDouble(), b.toDouble()).toInt()
  }

  private fun g(nums: IntArray): Int {
    val m = nums.size
    val f = Array(m + 1) { IntArray(n + 1) }
    for (i in 1..m) {
      for (j in 1..n) {
        f[i][j] = max(f[i - 1][j].toDouble(), ((if (i >= 2) f[i - 2][j - 1] else 0) + nums[i - 1]).toDouble())
          .toInt()
      }
    }
    return f[m][n]
  }
}
