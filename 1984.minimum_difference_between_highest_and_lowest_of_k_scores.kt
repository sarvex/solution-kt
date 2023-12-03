import kotlin.math.min

class Solution {
  fun minimumDifference(nums: IntArray, k: Int): Int {
    Arrays.sort(nums)
    var ans = 100000
    for (i in 0 until nums.size - k + 1) {
      ans = min(ans.toDouble(), (nums[i + k - 1] - nums[i]).toDouble()).toInt()
    }
    return ans
  }
}
