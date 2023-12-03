import kotlin.math.max

class Solution {
  fun maximumDifference(nums: IntArray): Int {
    var mi = 1 shl 30
    var ans = -1
    for (x in nums) {
      if (x > mi) {
        ans = max(ans.toDouble(), (x - mi).toDouble()).toInt()
      } else {
        mi = x
      }
    }
    return ans
  }
}
