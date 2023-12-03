internal class Solution {
  fun isMajorityElement(nums: IntArray, target: Int): Boolean {
    val left = search(nums, target)
    val right = search(nums, target + 1)
    return right - left > nums.size / 2
  }

  private fun search(nums: IntArray, x: Int): Int {
    var left = 0
    var right = nums.size
    while (left < right) {
      val mid = left + right shr 1
      if (nums[mid] >= x) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }
}
