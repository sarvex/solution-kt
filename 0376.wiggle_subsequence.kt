import kotlin.math.max

internal class Solution {
  fun wiggleMaxLength(nums: IntArray): Int {
    var up = 1
    var down = 1
    for (i in 1 until nums.size) {
      if (nums[i] > nums[i - 1]) {
        up = max(up.toDouble(), (down + 1).toDouble()).toInt()
      } else if (nums[i] < nums[i - 1]) {
        down = max(down.toDouble(), (up + 1).toDouble()).toInt()
      }
    }
    return max(up.toDouble(), down.toDouble()).toInt()
  }
}
