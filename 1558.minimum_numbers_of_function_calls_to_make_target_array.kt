import kotlin.math.max

class Solution {
  fun minOperations(nums: IntArray): Int {
    var ans = 0
    var mx = 0
    for (v in nums) {
      mx = max(mx.toDouble(), v.toDouble()).toInt()
      ans += Integer.bitCount(v)
    }
    ans += Integer.toBinaryString(mx).length - 1
    return ans
  }
}
