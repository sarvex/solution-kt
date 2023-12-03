import kotlin.math.max

internal class Solution {
  fun largestEvenSum(nums: IntArray, k: Int): Long {
    Arrays.sort(nums)
    var ans: Long = 0
    val n = nums.size
    for (i in 0 until k) {
      ans += nums[n - i - 1].toLong()
    }
    if (ans % 2 == 0L) {
      return ans
    }
    val inf = 1 shl 29
    var mx1 = -inf
    var mx2 = -inf
    for (i in 0 until n - k) {
      if (nums[i] % 2 == 1) {
        mx1 = nums[i]
      } else {
        mx2 = nums[i]
      }
    }
    var mi1 = inf
    var mi2 = inf
    for (i in n - 1 downTo n - k) {
      if (nums[i] % 2 == 1) {
        mi2 = nums[i]
      } else {
        mi1 = nums[i]
      }
    }
    ans = max(-1.0, max((ans - mi1 + mx1).toDouble(), (ans - mi2 + mx2).toDouble())).toLong()
    return if (ans % 2 != 0L) -1 else ans
  }
}
