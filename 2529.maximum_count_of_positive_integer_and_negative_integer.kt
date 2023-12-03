import kotlin.math.max

class Solution {
  fun maximumCount(nums: IntArray): Int {
    val a = nums.size - search(nums, 1)
    val b = search(nums, 0)
    return max(a.toDouble(), b.toDouble()).toInt()
  }

  private fun search(nums: IntArray, x: Int): Int {
    var left = 0
    var right = nums.size
    while (left < right) {
      val mid = left + right shr 1
      if (nums[mid] >= x) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }
}
