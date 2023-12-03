import kotlin.math.min

class Solution {
  fun minimumXORSum(nums1: IntArray, nums2: IntArray): Int {
    val n = nums1.size
    val f = IntArray(1 shl n)
    Arrays.fill(f, 1 shl 30)
    f[0] = 0
    for (i in 0 until (1 shl n)) {
      val k = Integer.bitCount(i) - 1
      for (j in 0 until n) {
        if (i shr j and 1 == 1) {
          f[i] = min(f[i].toDouble(), (f[i xor (1 shl j)] + (nums1[k] xor nums2[j])).toDouble())
            .toInt()
        }
      }
    }
    return f[(1 shl n) - 1]
  }
}
