import kotlin.math.abs

class Solution {
  fun leftRigthDifference(nums: IntArray): IntArray {
    var left = 0
    var right: Int = Arrays.stream(nums).sum()
    val n = nums.size
    val ans = IntArray(n)
    for (i in 0 until n) {
      right -= nums[i]
      ans[i] = abs((left - right).toDouble()).toInt()
      left += nums[i]
    }
    return ans
  }
}
