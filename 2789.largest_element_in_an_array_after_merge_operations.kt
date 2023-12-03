import kotlin.math.max

class Solution {
  fun maxArrayValue(nums: IntArray): Long {
    val n = nums.size
    var ans = nums[n - 1].toLong()
    var t = nums[n - 1].toLong()
    for (i in n - 2 downTo 0) {
      if (nums[i] <= t) {
        t += nums[i].toLong()
      } else {
        t = nums[i].toLong()
      }
      ans = max(ans.toDouble(), t.toDouble()).toLong()
    }
    return ans
  }
}
