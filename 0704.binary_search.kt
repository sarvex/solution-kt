internal class Solution {
  fun search(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    while (left < right) {
      val mid = left + right shr 1
      if (nums[mid] >= target) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return if (nums[left] == target) left else -1
  }
}
