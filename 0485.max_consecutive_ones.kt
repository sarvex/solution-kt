import kotlin.math.max

internal class Solution {
  fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var cnt = 0
    var ans = 0
    for (v in nums) {
      if (v == 1) {
        ++cnt
      } else {
        ans = max(ans.toDouble(), cnt.toDouble()).toInt()
        cnt = 0
      }
    }
    return max(cnt.toDouble(), ans.toDouble()).toInt()
  }
}
