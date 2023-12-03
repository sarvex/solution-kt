import kotlin.math.min
import kotlin.math.sqrt

internal class Solution {
  fun numSquares(n: Int): Int {
    val m = sqrt(n.toDouble()).toInt()
    val f = IntArray(n + 1)
    Arrays.fill(f, 1 shl 30)
    f[0] = 0
    for (i in 1..m) {
      for (j in i * i..n) {
        f[j] = min(f[j].toDouble(), (f[j - i * i] + 1).toDouble()).toInt()
      }
    }
    return f[n]
  }
}
