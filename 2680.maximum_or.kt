import kotlin.math.max

class Solution {
  fun maximumOr(nums: IntArray, k: Int): Long {
    val n = nums.size
    val suf = LongArray(n + 1)
    for (i in n - 1 downTo 0) {
      suf[i] = suf[i + 1] or nums[i].toLong()
    }
    var ans: Long = 0
    var pre: Long = 0
    for (i in 0 until n) {
      ans = max(ans.toDouble(), (pre or (1L * nums[i] shl k) or suf[i + 1]).toDouble()).toLong()
      pre = pre or nums[i].toLong()
    }
    return ans
  }
}
