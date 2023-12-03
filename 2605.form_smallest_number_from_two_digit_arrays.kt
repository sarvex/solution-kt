import kotlin.math.min

class Solution {
  fun minNumber(nums1: IntArray, nums2: IntArray): Int {
    var mask1 = 0
    var mask2 = 0
    for (x in nums1) {
      mask1 = mask1 or (1 shl x)
    }
    for (x in nums2) {
      mask2 = mask2 or (1 shl x)
    }
    val mask = mask1 and mask2
    if (mask != 0) {
      return Integer.numberOfTrailingZeros(mask)
    }
    val a = Integer.numberOfTrailingZeros(mask1)
    val b = Integer.numberOfTrailingZeros(mask2)
    return min((a * 10 + b).toDouble(), (b * 10 + a).toDouble()).toInt()
  }
}
