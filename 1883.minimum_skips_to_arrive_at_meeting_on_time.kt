import kotlin.math.ceil
import kotlin.math.min

class Solution {
  fun minSkips(dist: IntArray, speed: Int, hoursBefore: Int): Int {
    val n = dist.size
    val f = Array(n + 1) { DoubleArray(n + 1) }
    for (i in 0..n) {
      Arrays.fill(f[i], 1e20)
    }
    f[0][0] = 0.0
    val eps = 1e-8
    for (i in 1..n) {
      for (j in 0..i) {
        if (j < i) {
          f[i][j] = min(
            f[i][j], ceil(f[i - 1][j]) + 1.0 * dist[i - 1] / speed - eps
          )
        }
        if (j > 0) {
          f[i][j] = min(f[i][j], f[i - 1][j - 1] + 1.0 * dist[i - 1] / speed)
        }
      }
    }
    for (j in 0..n) {
      if (f[n][j] <= hoursBefore + eps) {
        return j
      }
    }
    return -1
  }
}
