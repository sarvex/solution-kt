internal class Solution {
  fun nthUglyNumber(n: Int, a: Int, b: Int, c: Int): Int {
    val ab = lcm(a.toLong(), b.toLong())
    val bc = lcm(b.toLong(), c.toLong())
    val ac = lcm(a.toLong(), c.toLong())
    val abc = lcm(ab, c.toLong())
    var l: Long = 1
    var r: Long = 2000000000
    while (l < r) {
      val mid = l + r shr 1
      if (mid / a + mid / b + mid / c - mid / ab - mid / bc - mid / ac + mid / abc >= n) {
        r = mid
      } else {
        l = mid + 1
      }
    }
    return l.toInt()
  }

  private fun gcd(a: Long, b: Long): Long {
    return if (b == 0L) a else gcd(b, a % b)
  }

  private fun lcm(a: Long, b: Long): Long {
    return a * b / gcd(a, b)
  }
}
