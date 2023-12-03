import kotlin.math.max

class Solution {
  fun longestSubarray(nums: IntArray): Int {
    val n = nums.size
    val left = IntArray(n)
    val right = IntArray(n)
    for (i in 1 until n) {
      if (nums[i - 1] == 1) {
        left[i] = left[i - 1] + 1
      }
    }
    for (i in n - 2 downTo 0) {
      if (nums[i + 1] == 1) {
        right[i] = right[i + 1] + 1
      }
    }
    var ans = 0
    for (i in 0 until n) {
      ans = max(ans.toDouble(), (left[i] + right[i]).toDouble()).toInt()
    }
    return ans
  }
}
