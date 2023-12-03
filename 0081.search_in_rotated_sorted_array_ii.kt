internal class Solution {
  fun search(nums: IntArray, target: Int): Boolean {
    var l = 0
    var r = nums.size - 1
    while (l < r) {
      val mid = l + r shr 1
      if (nums[mid] > nums[r]) {
        if (nums[l] <= target && target <= nums[mid]) {
          r = mid
        } else {
          l = mid + 1
        }
      } else if (nums[mid] < nums[r]) {
        if (nums[mid] < target && target <= nums[r]) {
          l = mid + 1
        } else {
          r = mid
        }
      } else {
        --r
      }
    }
    return nums[l] == target
  }
}
