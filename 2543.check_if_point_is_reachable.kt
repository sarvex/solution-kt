class Solution {
  fun isReachable(targetX: Int, targetY: Int): Boolean {
    val x = gcd(targetX, targetY)
    return x and x - 1 == 0
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
  }
}
