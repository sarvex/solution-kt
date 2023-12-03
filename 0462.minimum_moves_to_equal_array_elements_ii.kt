import kotlin.math.abs

internal class Solution {
  fun minMoves2(nums: IntArray): Int {
    Arrays.sort(nums)
    val k = nums[nums.size shr 1]
    var ans = 0
    for (v in nums) {
      (ans += abs((v - k).toDouble())).toInt()
    }
    return ans
  }
}
