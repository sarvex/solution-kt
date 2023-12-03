internal class Solution {
  fun nextPermutation(nums: IntArray) {
    val n = nums.size
    var i = n - 2
    while (i >= 0) {
      if (nums[i] < nums[i + 1]) {
        break
      }
      --i
    }
    if (i >= 0) {
      for (j in n - 1 downTo i + 1) {
        if (nums[j] > nums[i]) {
          swap(nums, i, j)
          break
        }
      }
    }
    var j = i + 1
    var k = n - 1
    while (j < k) {
      swap(nums, j, k)
      ++j
      --k
    }
  }

  private fun swap(nums: IntArray, i: Int, j: Int) {
    val t = nums[j]
    nums[j] = nums[i]
    nums[i] = t
  }
}
