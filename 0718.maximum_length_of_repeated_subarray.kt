import kotlin.math.max

internal class Solution {
  fun findLength(nums1: IntArray, nums2: IntArray): Int {
    val m = nums1.size
    val n = nums2.size
    val f = Array(m + 1) { IntArray(n + 1) }
    var ans = 0
    for (i in 1..m) {
      for (j in 1..n) {
        if (nums1[i - 1] == nums2[j - 1]) {
          f[i][j] = f[i - 1][j - 1] + 1
          ans = max(ans.toDouble(), f[i][j].toDouble()).toInt()
        }
      }
    }
    return ans
  }
}
