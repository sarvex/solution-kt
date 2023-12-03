internal class Solution {
  fun search(nums: IntArray, target: Int): Int {
    val n = nums.size
    var left = 0
    var right = n - 1
    while (left < right) {
      val mid = left + right shr 1
      if (nums[0] <= nums[mid]) {
        if (nums[0] <= target && target <= nums[mid]) {
          right = mid
        } else {
          left = mid + 1
        }
      } else {
        if (nums[mid] < target && target <= nums[n - 1]) {
          left = mid + 1
        } else {
          right = mid
        }
      }
    }
    return if (nums[left] == target) left else -1
  }
}
