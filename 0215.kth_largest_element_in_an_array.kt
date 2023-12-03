internal class Solution {
  fun findKthLargest(nums: IntArray, k: Int): Int {
    val n = nums.size
    return quickSort(nums, 0, n - 1, n - k)
  }

  private fun quickSort(nums: IntArray, left: Int, right: Int, k: Int): Int {
    if (left == right) {
      return nums[left]
    }
    var i = left - 1
    var j = right + 1
    val x = nums[left + right ushr 1]
    while (i < j) {
      while (nums[++i] < x);
      while (nums[--j] > x);
      if (i < j) {
        val t = nums[i]
        nums[i] = nums[j]
        nums[j] = t
      }
    }
    return if (j < k) {
      quickSort(nums, j + 1, right, k)
    } else quickSort(nums, left, j, k)
  }
}
