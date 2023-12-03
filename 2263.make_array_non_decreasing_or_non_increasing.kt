import kotlin.math.abs
import kotlin.math.min

class Solution {
  fun convertArray(nums: IntArray): Int {
    return min(solve(nums).toDouble(), solve(reverse(nums)).toDouble()).toInt()
  }

  private fun solve(nums: IntArray): Int {
    val n = nums.size
    val f = Array(n + 1) { IntArray(1001) }
    for (i in 1..n) {
      var mi = 1 shl 30
      for (j in 0..1000) {
        mi = min(mi.toDouble(), f[i - 1][j].toDouble()).toInt()
        f[i][j] = (mi + abs((j - nums[i - 1]).toDouble())).toInt()
      }
    }
    var ans = 1 shl 30
    for (x in f[n]) {
      ans = min(ans.toDouble(), x.toDouble()).toInt()
    }
    return ans
  }

  private fun reverse(nums: IntArray): IntArray {
    var i = 0
    var j = nums.size - 1
    while (i < j) {
      val t = nums[i]
      nums[i] = nums[j]
      nums[j] = t
      ++i
      --j
    }
    return nums
  }
}
