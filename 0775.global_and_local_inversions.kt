import kotlin.math.max

internal class Solution {
  fun isIdealPermutation(nums: IntArray): Boolean {
    var mx = 0
    for (i in 2 until nums.size) {
      mx = max(mx.toDouble(), nums[i - 2].toDouble()).toInt()
      if (mx > nums[i]) {
        return false
      }
    }
    return true
  }
}
