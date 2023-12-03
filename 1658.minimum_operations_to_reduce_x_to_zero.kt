import kotlin.math.min

class Solution {
  fun minOperations(nums: IntArray, x: Int): Int {
    var x = x
    x = -x
    for (v in nums) {
      x += v
    }
    val n = nums.size
    var ans = 1 shl 30
    var i = 0
    var j = 0
    var s = 0
    while (i < n) {
      s += nums[i]
      while (j <= i && s > x) {
        s -= nums[j++]
      }
      if (s == x) {
        ans = min(ans.toDouble(), (n - (i - j + 1)).toDouble()).toInt()
      }
      ++i
    }
    return if (ans == 1 shl 30) -1 else ans
  }
}
