internal class Solution {
  fun checkPossibility(nums: IntArray): Boolean {
    for (i in 0 until nums.size - 1) {
      val a = nums[i]
      val b = nums[i + 1]
      if (a > b) {
        nums[i] = b
        if (isSorted(nums)) {
          return true
        }
        nums[i] = a
        nums[i + 1] = a
        return isSorted(nums)
      }
    }
    return true
  }

  private fun isSorted(nums: IntArray): Boolean {
    for (i in 0 until nums.size - 1) {
      if (nums[i] > nums[i + 1]) {
        return false
      }
    }
    return true
  }
}
