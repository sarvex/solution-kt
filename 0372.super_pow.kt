internal class Solution {
  private val mod = 1337
  fun superPow(a: Int, b: IntArray): Int {
    var a = a
    var ans: Long = 1
    for (i in b.indices.reversed()) {
      ans = ans * qpow(a.toLong(), b[i]) % mod
      a = qpow(a.toLong(), 10).toInt()
    }
    return ans.toInt()
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
