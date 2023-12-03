internal class Solution {
  fun missingElement(nums: IntArray, k: Int): Int {
    val n = nums.size
    if (k > missing(nums, n - 1)) {
      return nums[n - 1] + k - missing(nums, n - 1)
    }
    var l = 0
    var r = n - 1
    while (l < r) {
      val mid = l + r shr 1
      if (missing(nums, mid) >= k) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return nums[l - 1] + k - missing(nums, l - 1)
  }

  private fun missing(nums: IntArray, i: Int): Int {
    return nums[i] - nums[0] - i
  }
}
