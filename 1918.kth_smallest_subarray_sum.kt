import kotlin.math.min

class Solution {
  fun kthSmallestSubarraySum(nums: IntArray, k: Int): Int {
    var l = 1 shl 30
    var r = 0
    for (x in nums) {
      l = min(l.toDouble(), x.toDouble()).toInt()
      r += x
    }
    while (l < r) {
      val mid = l + r shr 1
      if (f(nums, mid) >= k) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l
  }

  private fun f(nums: IntArray, s: Int): Int {
    var t = 0
    var j = 0
    var cnt = 0
    for (i in nums.indices) {
      t += nums[i]
      while (t > s) {
        t -= nums[j++]
      }
      cnt += i - j + 1
    }
    return cnt
  }
}
