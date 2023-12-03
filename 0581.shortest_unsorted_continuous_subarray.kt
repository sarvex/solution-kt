internal class Solution {
  fun findUnsortedSubarray(nums: IntArray): Int {
    val inf = 1 shl 30
    val n = nums.size
    var l = -1
    var r = -1
    var mi = inf
    var mx = -inf
    for (i in 0 until n) {
      if (mx > nums[i]) {
        r = i
      } else {
        mx = nums[i]
      }
      if (mi < nums[n - i - 1]) {
        l = n - i - 1
      } else {
        mi = nums[n - i - 1]
      }
    }
    return if (r == -1) 0 else r - l + 1
  }
}
