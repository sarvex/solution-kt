import kotlin.math.max

class Solution {
  fun largestMultipleOfThree(digits: IntArray): String {
    Arrays.sort(digits)
    val n = digits.size
    val f = Array(n + 1) { IntArray(3) }
    val inf = 1 shl 30
    for (g in f) {
      Arrays.fill(g, -inf)
    }
    f[0][0] = 0
    for (i in 1..n) {
      for (j in 0..2) {
        f[i][j] = max(f[i - 1][j].toDouble(), (f[i - 1][(j - digits[i - 1] % 3 + 3) % 3] + 1).toDouble())
          .toInt()
      }
    }
    if (f[n][0] <= 0) {
      return ""
    }
    val sb = StringBuilder()
    run {
      var i = n
      var j = 0
      while (i > 0) {
        val k = (j - digits[i - 1] % 3 + 3) % 3
        if (f[i - 1][k] + 1 == f[i][j]) {
          sb.append(digits[i - 1])
          j = k
        }
        --i
      }
    }
    var i = 0
    while (i < sb.length - 1 && sb[i] == '0') {
      ++i
    }
    return sb.substring(i)
  }
}
