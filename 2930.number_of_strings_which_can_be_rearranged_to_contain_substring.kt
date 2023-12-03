class Solution {
  private val mod = 1e9.toInt() + 7
  fun stringCount(n: Int): Int {
    val a = qpow(25, n)
    val c = (qpow(25, n) + n * qpow(25, n - 1) % mod) % mod
    val ab = qpow(24, n)
    val ac = (qpow(24, n) + n * qpow(24, n - 1) % mod) % mod
    val abc = (qpow(23, n) + n * qpow(23, n - 1) % mod) % mod
    val tot = qpow(26, n)
    return ((tot - (a + a + c - ab - ac - ac + abc)) % mod + mod).toInt() % mod
  }

  private fun qpow(a: Long, n: Int): Long {
    var a = a
    var n = n
    var ans: Long = 1
    while (n > 0) {
      if (n and 1 == 1) {
        ans = ans * a % mod
      }
      a = a * a % mod
      n = n shr 1
    }
    return ans
  }
}
