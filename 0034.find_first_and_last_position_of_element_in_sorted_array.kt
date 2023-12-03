internal class Solution {
  fun searchRange(nums: IntArray, target: Int): IntArray {
    val l = search(nums, target)
    val r = search(nums, target + 1)
    return if (l == r) intArrayOf(-1, -1) else intArrayOf(l, r - 1)
  }

  private fun search(nums: IntArray, x: Int): Int {
    var left = 0
    var right = nums.size
    while (left < right) {
      val mid = left + right ushr 1
      if (nums[mid] >= x) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }
}
