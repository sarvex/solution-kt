import kotlin.math.abs
import kotlin.math.min

internal class Solution {
  fun assignBikes(workers: Array<IntArray>, bikes: Array<IntArray>): Int {
    val n = workers.size
    val m = bikes.size
    val f = Array(n + 1) { IntArray(1 shl m) }
    for (g in f) {
      Arrays.fill(g, 1 shl 30)
    }
    f[0][0] = 0
    for (i in 1..n) {
      for (j in 0 until (1 shl m)) {
        for (k in 0 until m) {
          if (j shr k and 1 == 1) {
            val d =
              (abs((workers[i - 1][0] - bikes[k][0]).toDouble()) + abs((workers[i - 1][1] - bikes[k][1]).toDouble())).toInt()
            f[i][j] = min(f[i][j].toDouble(), (f[i - 1][j xor (1 shl k)] + d).toDouble())
              .toInt()
          }
        }
      }
    }
    return Arrays.stream(f[n]).min().getAsInt()
  }
}
