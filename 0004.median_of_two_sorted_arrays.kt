import kotlin.math.min

internal class Solution {
  private var m = 0
  private var n = 0
  private var nums1: IntArray
  private var nums2: IntArray
  fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    m = nums1.size
    n = nums2.size
    this.nums1 = nums1
    this.nums2 = nums2
    val a = f(0, 0, (m + n + 1) / 2)
    val b = f(0, 0, (m + n + 2) / 2)
    return (a + b) / 2.0
  }

  private fun f(i: Int, j: Int, k: Int): Int {
    if (i >= m) {
      return nums2[j + k - 1]
    }
    if (j >= n) {
      return nums1[i + k - 1]
    }
    if (k == 1) {
      return min(nums1[i].toDouble(), nums2[j].toDouble()).toInt()
    }
    val p = k / 2
    val x = if (i + p - 1 < m) nums1[i + p - 1] else 1 shl 30
    val y = if (j + p - 1 < n) nums2[j + p - 1] else 1 shl 30
    return if (x < y) f(i + p, j, k - p) else f(i, j + p, k - p)
  }
}
