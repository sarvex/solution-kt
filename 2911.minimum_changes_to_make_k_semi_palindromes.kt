import kotlin.math.min

class Solution {
  fun minimumChanges(s: String, k: Int): Int {
    val n = s.length
    val g = Array(n + 1) { IntArray(n + 1) }
    val f = Array(n + 1) { IntArray(k + 1) }
    val inf = 1 shl 30
    for (i in 0..n) {
      Arrays.fill(g[i], inf)
      Arrays.fill(f[i], inf)
    }
    for (i in 1..n) {
      for (j in i..n) {
        val m = j - i + 1
        for (d in 1 until m) {
          if (m % d == 0) {
            var cnt = 0
            for (l in 0 until m) {
              val r = (m / d - 1 - l / d) * d + l % d
              if (l >= r) {
                break
              }
              if (s[i - 1 + l] != s[i - 1 + r]) {
                ++cnt
              }
            }
            g[i][j] = min(g[i][j].toDouble(), cnt.toDouble()).toInt()
          }
        }
      }
    }
    f[0][0] = 0
    for (i in 1..n) {
      for (j in 1..k) {
        for (h in 0 until i - 1) {
          f[i][j] = min(f[i][j].toDouble(), (f[h][j - 1] + g[h + 1][i]).toDouble())
            .toInt()
        }
      }
    }
    return f[n][k]
  }
}
