import kotlin.math.max

class Solution {
  fun maximumsSplicedArray(nums1: IntArray, nums2: IntArray): Int {
    var s1 = 0
    var s2 = 0
    val n = nums1.size
    for (i in 0 until n) {
      s1 += nums1[i]
      s2 += nums2[i]
    }
    return max((s2 + f(nums1, nums2)).toDouble(), (s1 + f(nums2, nums1)).toDouble()).toInt()
  }

  private fun f(nums1: IntArray, nums2: IntArray): Int {
    var t = nums1[0] - nums2[0]
    var mx = t
    for (i in 1 until nums1.size) {
      val v = nums1[i] - nums2[i]
      if (t > 0) {
        t += v
      } else {
        t = v
      }
      mx = max(mx.toDouble(), t.toDouble()).toInt()
    }
    return mx
  }
}
