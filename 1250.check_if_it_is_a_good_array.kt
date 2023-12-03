class Solution {
  fun isGoodArray(nums: IntArray): Boolean {
    var g = 0
    for (x in nums) {
      g = gcd(x, g)
    }
    return g == 1
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
  }
}
