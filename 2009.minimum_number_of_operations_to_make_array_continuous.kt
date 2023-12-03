import kotlin.math.min

internal class Solution {
  fun minOperations(nums: IntArray): Int {
    val n = nums.size
    Arrays.sort(nums)
    var m = 1
    for (i in 1 until n) {
      if (nums[i] != nums[i - 1]) {
        nums[m++] = nums[i]
      }
    }
    var ans = n
    var i = 0
    var j = 0
    while (i < m) {
      while (j < m && nums[j] - nums[i] <= n - 1) {
        ++j
      }
      ans = min(ans.toDouble(), (n - (j - i)).toDouble()).toInt()
      ++i
    }
    return ans
  }
}
