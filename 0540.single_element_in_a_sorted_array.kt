internal class Solution {
  fun singleNonDuplicate(nums: IntArray): Int {
    var left = 0
    var right = nums.size - 1
    while (left < right) {
      val mid = left + right shr 1
      // if ((mid % 2 == 0 && nums[mid] != nums[mid + 1]) || (mid % 2 == 1 && nums[mid] !=
      // nums[mid - 1])) {
      if (nums[mid] != nums[mid xor 1]) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return nums[left]
  }
}
