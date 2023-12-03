import kotlin.math.max

class Solution {
  fun longestSubarray(nums: IntArray): Int {
    var mx = 0
    for (v in nums) {
      mx = max(mx.toDouble(), v.toDouble()).toInt()
    }
    var ans = 0
    var cnt = 0
    for (v in nums) {
      if (v == mx) {
        ++cnt
        ans = max(ans.toDouble(), cnt.toDouble()).toInt()
      } else {
        cnt = 0
      }
    }
    return ans
  }
}
