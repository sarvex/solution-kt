import kotlin.math.abs

class Solution {
  fun minimumAverageDifference(nums: IntArray): Int {
    val n = nums.size
    var pre: Long = 0
    var suf: Long = 0
    for (x in nums) {
      suf += x.toLong()
    }
    var ans = 0
    var mi = Long.MAX_VALUE
    for (i in 0 until n) {
      pre += nums[i].toLong()
      suf -= nums[i].toLong()
      val a = pre / (i + 1)
      val b = if (n - i - 1 == 0) 0 else suf / (n - i - 1)
      val t = abs((a - b).toDouble()).toLong()
      if (t < mi) {
        ans = i
        mi = t
      }
    }
    return ans
  }
}
