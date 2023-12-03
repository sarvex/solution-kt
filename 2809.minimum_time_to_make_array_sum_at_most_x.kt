import kotlin.math.max

class Solution {
  fun minimumTime(nums1: List<Int>, nums2: List<Int>, x: Int): Int {
    val n: Int = nums1.size()
    val f = IntArray(n + 1)
    val nums = Array(n) { IntArray(0) }
    for (i in 0 until n) {
      nums[i] = intArrayOf(nums1[i], nums2[i])
    }
    Arrays.sort(nums, Comparator.comparingInt { a -> a.get(1) })
    for (e in nums) {
      val a = e[0]
      val b = e[1]
      for (j in n downTo 1) {
        f[j] = max(f[j].toDouble(), (f[j - 1] + a + b * j).toDouble()).toInt()
      }
    }
    var s1 = 0
    var s2 = 0
    for (v in nums1) {
      s1 += v
    }
    for (v in nums2) {
      s2 += v
    }
    for (j in 0..n) {
      if (s1 + s2 * j - f[j] <= x) {
        return j
      }
    }
    return -1
  }
}
