import kotlin.math.max
import kotlin.math.min

class Solution {
  fun minDifficulty(jobDifficulty: IntArray, d: Int): Int {
    val inf = 1 shl 30
    val n = jobDifficulty.size
    val f = Array(n + 1) { IntArray(d + 1) }
    for (g in f) {
      Arrays.fill(g, inf)
    }
    f[0][0] = 0
    for (i in 1..n) {
      for (j in 1..min(d.toDouble(), i.toDouble()).toInt()) {
        var mx = 0
        for (k in i downTo 1) {
          mx = max(mx.toDouble(), jobDifficulty[k - 1].toDouble()).toInt()
          f[i][j] = min(f[i][j].toDouble(), (f[k - 1][j - 1] + mx).toDouble())
            .toInt()
        }
      }
    }
    return if (f[n][d] >= inf) -1 else f[n][d]
  }
}
