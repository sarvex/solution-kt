internal class Solution {
  fun wiggleSort(nums: IntArray) {
    for (i in 1 until nums.size) {
      if (i % 2 == 1 && nums[i] < nums[i - 1] || i % 2 == 0 && nums[i] > nums[i - 1]) {
        swap(nums, i, i - 1)
      }
    }
  }

  private fun swap(nums: IntArray, i: Int, j: Int) {
    val t = nums[i]
    nums[i] = nums[j]
    nums[j] = t
  }
}
