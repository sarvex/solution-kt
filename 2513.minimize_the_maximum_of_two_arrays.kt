class Solution {
  fun minimizeSet(divisor1: Int, divisor2: Int, uniqueCnt1: Int, uniqueCnt2: Int): Int {
    val divisor = lcm(divisor1, divisor2)
    var left: Long = 1
    var right = 10000000000L
    while (left < right) {
      val mid = left + right shr 1
      val cnt1 = mid / divisor1 * (divisor1 - 1) + mid % divisor1
      val cnt2 = mid / divisor2 * (divisor2 - 1) + mid % divisor2
      val cnt = mid / divisor * (divisor - 1) + mid % divisor
      if (cnt1 >= uniqueCnt1 && cnt2 >= uniqueCnt2 && cnt >= uniqueCnt1 + uniqueCnt2) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left.toInt()
  }

  private fun lcm(a: Int, b: Int): Long {
    return a.toLong() * b / gcd(a, b)
  }

  private fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
  }
}
