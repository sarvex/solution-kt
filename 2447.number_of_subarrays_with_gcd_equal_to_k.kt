class Solution {
  fun subarrayGCD(nums: IntArray, k: Int): Int {
    val n = nums.size
    var ans = 0
    for (i in 0 until n) {
      var g = 0
      for (j in i until n) {
        g = gcd(g, nums[j])
        if (g == k) {
          ++ans
        }
      }
    }
    return ans
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
  }
}
