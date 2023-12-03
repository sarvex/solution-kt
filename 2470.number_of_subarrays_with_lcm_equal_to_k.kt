class Solution {
  fun subarrayLCM(nums: IntArray, k: Int): Int {
    val n = nums.size
    var ans = 0
    for (i in 0 until n) {
      var a = nums[i]
      for (j in i until n) {
        val b = nums[j]
        val x = lcm(a, b)
        if (x == k) {
          ++ans
        }
        a = x
      }
    }
    return ans
  }

  private fun lcm(a: Int, b: Int): Int {
    return a * b / gcd(a, b)
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
  }
}
