class Solution {
  fun minimumSplits(nums: IntArray): Int {
    var ans = 1
    var g = 0
    for (x in nums) {
      g = gcd(g, x)
      if (g == 1) {
        ++ans
        g = x
      }
    }
    return ans
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
  }
}
