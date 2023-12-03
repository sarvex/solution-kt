import kotlin.math.max

internal class Solution {
  fun arrayNesting(nums: IntArray): Int {
    var ans = 0
    val n = nums.size
    for (i in 0 until n) {
      var cnt = 0
      var j = i
      while (nums[j] < n) {
        val k = nums[j]
        nums[j] = n
        j = k
        ++cnt
      }
      ans = max(ans.toDouble(), cnt.toDouble()).toInt()
    }
    return ans
  }
}
