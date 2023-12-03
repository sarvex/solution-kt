import kotlin.math.min

internal class Solution {
  fun minSubArrayLen(target: Int, nums: IntArray): Int {
    val n = nums.size
    var s: Long = 0
    var ans = n + 1
    var i = 0
    var j = 0
    while (i < n) {
      s += nums[i].toLong()
      while (j < n && s >= target) {
        ans = min(ans.toDouble(), (i - j + 1).toDouble()).toInt()
        s -= nums[j++].toLong()
      }
      ++i
    }
    return if (ans <= n) ans else 0
  }
}
