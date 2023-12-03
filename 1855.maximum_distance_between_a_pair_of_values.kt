import kotlin.math.max

class Solution {
  fun maxDistance(nums1: IntArray, nums2: IntArray): Int {
    val m = nums1.size
    val n = nums2.size
    var ans = 0
    var i = 0
    var j = 0
    while (i < m) {
      while (j < n && nums1[i] <= nums2[j]) {
        ++j
      }
      ans = max(ans.toDouble(), (j - i - 1).toDouble()).toInt()
      ++i
    }
    return ans
  }
}
