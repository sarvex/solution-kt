internal class Solution {
  fun tribonacci(n: Int): Int {
    if (n == 0) {
      return 0
    }
    if (n < 3) {
      return 1
    }
    val a = arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 0, 1), intArrayOf(1, 0, 0))
    val res = pow(a, n - 3)
    var ans = 0
    for (x in res[0]) {
      ans += x
    }
    return ans
  }

  private fun mul(a: Array<IntArray>, b: Array<IntArray>): Array<IntArray> {
    val m = a.size
    val n = b[0].size
    val c = Array(m) { IntArray(n) }
    for (i in 0 until m) {
      for (j in 0 until n) {
        for (k in b.indices) {
          c[i][j] += a[i][k] * b[k][j]
        }
      }
    }
    return c
  }

  private fun pow(a: Array<IntArray>, n: Int): Array<IntArray> {
    var a = a
    var n = n
    var res = arrayOf(intArrayOf(1, 1, 0))
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
