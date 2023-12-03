internal class Solution {
  fun findMin(nums: IntArray): Int {
    val n = nums.size
    if (nums[0] <= nums[n - 1]) {
      return nums[0]
    }
    var left = 0
    var right = n - 1
    while (left < right) {
      val mid = left + right shr 1
      if (nums[0] <= nums[mid]) {
        left = mid + 1
      } else {
        right = mid
      }
    }
    return nums[left]
  }
}
