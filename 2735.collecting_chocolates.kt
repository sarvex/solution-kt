import kotlin.math.min

class Solution {
  fun minCost(nums: IntArray, x: Int): Long {
    val n = nums.size
    val f = Array(n) { IntArray(n) }
    for (i in 0 until n) {
      f[i][0] = nums[i]
      for (j in 1 until n) {
        f[i][j] = min(f[i][j - 1].toDouble(), nums[(i + j) % n].toDouble()).toInt()
      }
    }
    var ans = 1L shl 60
    for (j in 0 until n) {
      var cost = 1L * j * x
      for (i in 0 until n) {
        cost += f[i][j].toLong()
      }
      ans = min(ans.toDouble(), cost.toDouble()).toLong()
    }
    return ans
  }
}
