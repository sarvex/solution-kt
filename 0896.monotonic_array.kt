internal class Solution {
  fun isMonotonic(nums: IntArray): Boolean {
    var isIncr = false
    var isDecr = false
    for (i in 1 until nums.size) {
      if (nums[i] < nums[i - 1]) {
        isIncr = true
      } else if (nums[i] > nums[i - 1]) {
        isDecr = true
      }
      if (isIncr && isDecr) {
        return false
      }
    }
    return true
  }
}
