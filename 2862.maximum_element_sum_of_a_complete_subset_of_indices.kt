import kotlin.math.max

class Solution {
  fun maximumSum(nums: List<Int>): Long {
    var ans: Long = 0
    val n: Int = nums.size()
    for (k in 1..n) {
      var t: Long = 0
      var j = 1
      while (k * j * j <= n) {
        t += nums[k * j * j - 1]
        ++j
      }
      ans = max(ans.toDouble(), t.toDouble()).toLong()
    }
    return ans
  }
}
