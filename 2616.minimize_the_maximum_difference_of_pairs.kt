class Solution {
  fun minimizeMax(nums: IntArray, p: Int): Int {
    Arrays.sort(nums)
    val n = nums.size
    var l = 0
    var r = nums[n - 1] - nums[0] + 1
    while (l < r) {
      val mid = l + r ushr 1
      if (count(nums, mid) >= p) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l
  }

  private fun count(nums: IntArray, diff: Int): Int {
    var cnt = 0
    var i = 0
    while (i < nums.size - 1) {
      if (nums[i + 1] - nums[i] <= diff) {
        ++cnt
        ++i
      }
      ++i
    }
    return cnt
  }
}
