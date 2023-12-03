import kotlin.math.max

class Solution {
  fun maxNonDecreasingLength(nums1: IntArray, nums2: IntArray): Int {
    val n = nums1.size
    var f = 1
    var g = 1
    var ans = 1
    for (i in 1 until n) {
      var ff = 1
      var gg = 1
      if (nums1[i] >= nums1[i - 1]) {
        ff = max(ff.toDouble(), (f + 1).toDouble()).toInt()
      }
      if (nums1[i] >= nums2[i - 1]) {
        ff = max(ff.toDouble(), (g + 1).toDouble()).toInt()
      }
      if (nums2[i] >= nums1[i - 1]) {
        gg = max(gg.toDouble(), (f + 1).toDouble()).toInt()
      }
      if (nums2[i] >= nums2[i - 1]) {
        gg = max(gg.toDouble(), (g + 1).toDouble()).toInt()
      }
      f = ff
      g = gg
      ans = max(ans.toDouble(), max(f.toDouble(), g.toDouble())).toInt()
    }
    return ans
  }
}
