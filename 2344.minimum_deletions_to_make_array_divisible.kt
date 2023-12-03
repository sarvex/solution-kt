import kotlin.math.min

class Solution {
  fun minOperations(nums: IntArray, numsDivide: IntArray): Int {
    var x = 0
    for (v in numsDivide) {
      x = gcd(x, v)
    }
    var y = 1 shl 30
    for (v in nums) {
      if (x % v == 0) {
        y = min(y.toDouble(), v.toDouble()).toInt()
      }
    }
    if (y == 1 shl 30) {
      return -1
    }
    var ans = 0
    for (v in nums) {
      if (v < y) {
        ++ans
      }
    }
    return ans
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
  }
}
