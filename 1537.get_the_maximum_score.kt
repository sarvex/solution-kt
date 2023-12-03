import kotlin.math.max

class Solution {
  fun maxSum(nums1: IntArray, nums2: IntArray): Int {
    val mod = 1e9.toInt() + 7
    val m = nums1.size
    val n = nums2.size
    var i = 0
    var j = 0
    var f: Long = 0
    var g: Long = 0
    while (i < m || j < n) {
      if (i == m) {
        g += nums2[j++].toLong()
      } else if (j == n) {
        f += nums1[i++].toLong()
      } else if (nums1[i] < nums2[j]) {
        f += nums1[i++].toLong()
      } else if (nums1[i] > nums2[j]) {
        g += nums2[j++].toLong()
      } else {
        g = (max(f.toDouble(), g.toDouble()) + nums1[i]).toLong()
        f = g
        i++
        j++
      }
    }
    return (max(f.toDouble(), g.toDouble()) % mod).toInt()
  }
}
