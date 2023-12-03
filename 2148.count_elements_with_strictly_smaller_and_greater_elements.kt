import kotlin.math.max
import kotlin.math.min

class Solution {
  fun countElements(nums: IntArray): Int {
    var mi = 1000000
    var mx = -1000000
    for (num in nums) {
      mi = min(mi.toDouble(), num.toDouble()).toInt()
      mx = max(mx.toDouble(), num.toDouble()).toInt()
    }
    var ans = 0
    for (num in nums) {
      if (mi < num && num < mx) {
        ++ans
      }
    }
    return ans
  }
}
