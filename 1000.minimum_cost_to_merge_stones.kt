import kotlin.math.min

class Solution {
  fun mergeStones(stones: IntArray, K: Int): Int {
    val n = stones.size
    if ((n - 1) % (K - 1) != 0) {
      return -1
    }
    val s = IntArray(n + 1)
    for (i in 1..n) {
      s[i] = s[i - 1] + stones[i - 1]
    }
    val f = Array(n + 1) { Array(n + 1) { IntArray(K + 1) } }
    val inf = 1 shl 20
    for (g in f) {
      for (e in g) {
        Arrays.fill(e, inf)
      }
    }
    for (i in 1..n) {
      f[i][i][1] = 0
    }
    for (l in 2..n) {
      var i = 1
      while (i + l - 1 <= n) {
        val j = i + l - 1
        for (k in 1..K) {
          for (h in i until j) {
            f[i][j][k] = min(f[i][j][k].toDouble(), (f[i][h][1] + f[h + 1][j][k - 1]).toDouble())
              .toInt()
          }
        }
        f[i][j][1] = f[i][j][K] + s[j] - s[i - 1]
        ++i
      }
    }
    return f[1][n][1]
  }
}
