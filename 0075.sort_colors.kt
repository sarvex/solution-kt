internal class Solution {
  fun sortColors(nums: IntArray) {
    var i = -1
    var j = nums.size
    var k = 0
    while (k < j) {
      if (nums[k] == 0) {
        swap(nums, ++i, k++)
      } else if (nums[k] == 2) {
        swap(nums, --j, k)
      } else {
        ++k
      }
    }
  }

  private fun swap(nums: IntArray, i: Int, j: Int) {
    val t = nums[i]
    nums[i] = nums[j]
    nums[j] = t
  }
}
