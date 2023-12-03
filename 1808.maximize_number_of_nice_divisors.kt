class Solution {
  private val mod = 1e9.toInt() + 7
  fun maxNiceDivisors(primeFactors: Int): Int {
    if (primeFactors < 4) {
      return primeFactors
    }
    if (primeFactors % 3 == 0) {
      return qpow(3, (primeFactors / 3).toLong())
    }
    return if (primeFactors % 3 == 1) {
      (4L * qpow(3, (primeFactors / 3 - 1).toLong()) % mod).toInt()
    } else 2 * qpow(3, (primeFactors / 3).toLong()) % mod
  }

  private fun qpow(a: Long, n: Long): Int {
    var a = a
    var n = n
    var ans: Long = 1
    while (n > 0) {
      if (n and 1L == 1L) {
        ans = ans * a % mod
      }
      a = a * a % mod
      n = n shr 1
    }
    return ans.toInt()
  }
}
