internal class Solution {
  fun myPow(x: Double, n: Int): Double {
    return if (n >= 0) qpow(x, n.toLong()) else 1 / qpow(x, -n.toLong())
  }

  private fun qpow(a: Double, n: Long): Double {
    var a = a
    var n = n
    var ans = 1.0
    while (n > 0) {
      if (n and 1L == 1L) {
        ans = ans * a
      }
      a = a * a
      n = n shr 1
    }
    return ans
  }
}
