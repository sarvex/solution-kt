class Solution {
  fun minCapability(nums: IntArray, k: Int): Int {
    var left = 0
    var right = 1e9.toInt()
    while (left < right) {
      val mid = left + right shr 1
      if (f(nums, mid) >= k) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }

  private fun f(nums: IntArray, x: Int): Int {
    var cnt = 0
    var j = -2
    for (i in nums.indices) {
      if (nums[i] > x || i == j + 1) {
        continue
      }
      ++cnt
      j = i
    }
    return cnt
  }
}
