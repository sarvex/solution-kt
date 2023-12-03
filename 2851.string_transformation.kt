import kotlin.math.max

class Solution {
  private fun add(x: Int, y: Int): Int {
    var x = x
    if (y.let { x += it; x } >= Solution.Companion.M) {
      x -= Solution.Companion.M
    }
    return x
  }

  private fun mul(x: Long, y: Long): Int {
    return (x * y % Solution.Companion.M).toInt()
  }

  private fun getZ(s: String): IntArray {
    val n = s.length
    val z = IntArray(n)
    var i = 1
    var left = 0
    var right = 0
    while (i < n) {
      if (i <= right && z[i - left] <= right - i) {
        z[i] = z[i - left]
      } else {
        var z_i = max(0.0, (right - i + 1).toDouble()).toInt()
        while (i + z_i < n && s[i + z_i] == s[z_i]) {
          z_i++
        }
        z[i] = z_i
      }
      if (i + z[i] - 1 > right) {
        left = i
        right = i + z[i] - 1
      }
      ++i
    }
    return z
  }

  private fun matrixMultiply(a: Array<IntArray>, b: Array<IntArray>): Array<IntArray> {
    val m = a.size
    val n = a[0].size
    val p = b[0].size
    val r = Array(m) { IntArray(p) }
    for (i in 0 until m) {
      for (j in 0 until p) {
        for (k in 0 until n) {
          r[i][j] = add(r[i][j], mul(a[i][k].toLong(), b[k][j].toLong()))
        }
      }
    }
    return r
  }

  private fun matrixPower(a: Array<IntArray>, y: Long): Array<IntArray> {
    var y = y
    val n = a.size
    var r = Array(n) { IntArray(n) }
    for (i in 0 until n) {
      r[i][i] = 1
    }
    var x = Array(n) { IntArray(n) }
    for (i in 0 until n) {
      System.arraycopy(a[i], 0, x[i], 0, n)
    }
    while (y > 0) {
      if (y and 1L == 1L) {
        r = matrixMultiply(r, x)
      }
      x = matrixMultiply(x, x)
      y = y shr 1
    }
    return r
  }

  fun numberOfWays(s: String, t: String, k: Long): Int {
    var s = s
    val n = s.length
    val dp = matrixPower(arrayOf(intArrayOf(0, 1), intArrayOf(n - 1, n - 2)), k)[0]
    s += t + t
    val z = getZ(s)
    val m = n + n
    var result = 0
    for (i in n until m) {
      if (z[i] >= n) {
        result = add(result, dp[if (i - n == 0) 0 else 1])
      }
    }
    return result
  }

  companion object {
    private const val M = 1000000007
  }
}
