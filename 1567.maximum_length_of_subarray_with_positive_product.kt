import kotlin.math.max

class Solution {
  fun getMaxLen(nums: IntArray): Int {
    var f1 = if (nums[0] > 0) 1 else 0
    var f2 = if (nums[0] < 0) 1 else 0
    var res = f1
    for (i in 1 until nums.size) {
      if (nums[i] > 0) {
        ++f1
        f2 = if (f2 > 0) f2 + 1 else 0
      } else if (nums[i] < 0) {
        val pf1 = f1
        val pf2 = f2
        f2 = pf1 + 1
        f1 = if (pf2 > 0) pf2 + 1 else 0
      } else {
        f1 = 0
        f2 = 0
      }
      res = max(res.toDouble(), f1.toDouble()).toInt()
    }
    return res
  }
}
