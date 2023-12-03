class Solution {
  fun commonFactors(a: Int, b: Int): Int {
    val g = gcd(a, b)
    var ans = 0
    var x = 1
    while (x * x <= g) {
      if (g % x == 0) {
        ++ans
        if (x * x < g) {
          ++ans
        }
      }
      ++x
    }
    return ans
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
  }
}
