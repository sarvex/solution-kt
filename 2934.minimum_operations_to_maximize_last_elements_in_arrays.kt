import kotlin.math.min

class Solution {
  private var n = 0
  fun minOperations(nums1: IntArray, nums2: IntArray): Int {
    n = nums1.size
    val a = f(nums1, nums2, nums1[n - 1], nums2[n - 1])
    val b = f(nums1, nums2, nums2[n - 1], nums1[n - 1])
    return if (a + b == -2) -1 else min(a.toDouble(), (b + 1).toDouble()).toInt()
  }

  private fun f(nums1: IntArray, nums2: IntArray, x: Int, y: Int): Int {
    var cnt = 0
    for (i in 0 until n - 1) {
      if (nums1[i] <= x && nums2[i] <= y) {
        continue
      }
      if (!(nums1[i] <= y && nums2[i] <= x)) {
        return -1
      }
      ++cnt
    }
    return cnt
  }
}
