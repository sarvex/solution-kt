internal class Solution {
  fun findDuplicates(nums: IntArray): List<Int> {
    val n = nums.size
    for (i in 0 until n) {
      while (nums[i] != nums[nums[i] - 1]) {
        swap(nums, i, nums[i] - 1)
      }
    }
    val ans: List<Int> = ArrayList()
    for (i in 0 until n) {
      if (nums[i] != i + 1) {
        ans.add(nums[i])
      }
    }
    return ans
  }

  fun swap(nums: IntArray, i: Int, j: Int) {
    val t = nums[i]
    nums[i] = nums[j]
    nums[j] = t
  }
}
