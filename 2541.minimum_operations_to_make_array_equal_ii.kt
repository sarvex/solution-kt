import kotlin.math.abs

class Solution {
  fun minOperations(nums1: IntArray, nums2: IntArray, k: Int): Long {
    var ans: Long = 0
    var x: Long = 0
    for (i in nums1.indices) {
      val a = nums1[i]
      val b = nums2[i]
      if (k == 0) {
        if (a != b) {
          return -1
        }
        continue
      }
      if ((a - b) % k != 0) {
        return -1
      }
      val y = (a - b) / k
      (ans += abs(y.toDouble())).toLong()
      x += y.toLong()
    }
    return if (x == 0L) ans / 2 else -1
  }
}
