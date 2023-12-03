internal class Solution {
  private val mod = 1e9.toInt() + 7
  fun countVowelPermutation(n: Int): Int {
    val a = arrayOf(
      longArrayOf(0, 1, 0, 0, 0),
      longArrayOf(1, 0, 1, 0, 0),
      longArrayOf(1, 1, 0, 1, 1),
      longArrayOf(0, 0, 1, 0, 1),
      longArrayOf(1, 0, 0, 0, 0)
    )
    val res = pow(a, n - 1)
    var ans: Long = 0
    for (x in res[0]) {
      ans = (ans + x) % mod
    }
    return ans.toInt()
  }

  private fun mul(a: Array<LongArray>, b: Array<LongArray>): Array<LongArray> {
    val m = a.size
    val n = b[0].size
    val c = Array(m) { LongArray(n) }
    for (i in 0 until m) {
      for (j in 0 until n) {
        for (k in b.indices) {
          c[i][j] = (c[i][j] + a[i][k] * b[k][j]) % mod
        }
      }
    }
    return c
  }

  private fun pow(a: Array<LongArray>, n: Int): Array<LongArray> {
    var a = a
    var n = n
    var res = Array(1) { LongArray(a.size) }
    Arrays.fill(res[0], 1)
    while (n > 0) {
      if (n and 1 == 1) {
        res = mul(res, a)
      }
      a = mul(a, a)
      n = n shr 1
    }
    return res
  }
}
