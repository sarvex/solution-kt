import kotlin.math.abs

class Solution {
  fun findClosestNumber(nums: IntArray): Int {
    var ans = 0
    var d = 1 shl 30
    for (x in nums) {
      val y = abs(x.toDouble()).toInt()
      if (y < d || y == d && x > ans) {
        ans = x
        d = y
      }
    }
    return ans
  }
}
