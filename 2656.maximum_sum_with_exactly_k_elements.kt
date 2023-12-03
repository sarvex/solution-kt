import kotlin.math.max

class Solution {
  fun maximizeSum(nums: IntArray, k: Int): Int {
    var x = 0
    for (v in nums) {
      x = max(x.toDouble(), v.toDouble()).toInt()
    }
    return k * x + k * (k - 1) / 2
  }
}
