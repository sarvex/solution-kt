import kotlin.math.max

class Solution {
  fun minPairSum(nums: IntArray): Int {
    Arrays.sort(nums)
    var ans = 0
    val n = nums.size
    for (i in 0 until (n shr 1)) {
      ans = max(ans.toDouble(), (nums[i] + nums[n - i - 1]).toDouble()).toInt()
    }
    return ans
  }
}
