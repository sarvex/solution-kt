class Solution {
  fun minNonZeroProduct(p: Int): Int {
    val mod = 1e9.toInt() + 7
    val a = ((1L shl p) - 1) % mod
    val b = qpow(((1L shl p) - 2) % mod, (1L shl p - 1) - 1, mod)
    return (a * b % mod).toInt()
  }

  private fun qpow(a: Long, n: Long, mod: Int): Long {
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
    return ans
  }
}
