import kotlin.math.max

class Solution {
  fun maximumSumScore(nums: IntArray): Long {
    val n = nums.size
    val s = LongArray(n + 1)
    for (i in 0 until n) {
      s[i + 1] = s[i] + nums[i]
    }
    var ans = Long.MIN_VALUE
    for (i in 0 until n) {
      ans = max(ans.toDouble(), max(s[i + 1].toDouble(), (s[n] - s[i]).toDouble()))
        .toLong()
    }
    return ans
  }
}
