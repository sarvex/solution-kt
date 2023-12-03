import kotlin.math.max

class Solution {
  fun minSum(nums1: IntArray, nums2: IntArray): Long {
    var s1: Long = 0
    var s2: Long = 0
    var hasZero = false
    for (x in nums1) {
      hasZero = hasZero or (x == 0)
      (s1 += max(x.toDouble(), 1.0)).toLong()
    }
    for (x in nums2) {
      (s2 += max(x.toDouble(), 1.0)).toLong()
    }
    if (s1 > s2) {
      return minSum(nums2, nums1)
    }
    if (s1 == s2) {
      return s1
    }
    return if (hasZero) s2 else -1
  }
}
