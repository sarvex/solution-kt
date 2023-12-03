import kotlin.math.max

class Solution {
  fun tallestBillboard(rods: IntArray): Int {
    val n = rods.size
    var s = 0
    for (x in rods) {
      s += x
    }
    val f = Array(n + 1) { IntArray(s + 1) }
    for (e in f) {
      Arrays.fill(e, -(1 shl 30))
    }
    f[0][0] = 0
    var i = 1
    var t = 0
    while (i <= n) {
      val x = rods[i - 1]
      t += x
      for (j in 0..t) {
        f[i][j] = f[i - 1][j]
        if (j >= x) {
          f[i][j] = max(f[i][j].toDouble(), f[i - 1][j - x].toDouble()).toInt()
        }
        if (j + x <= t) {
          f[i][j] = max(f[i][j].toDouble(), (f[i - 1][j + x] + x).toDouble())
            .toInt()
        }
        if (j < x) {
          f[i][j] = max(f[i][j].toDouble(), (f[i - 1][x - j] + x - j).toDouble())
            .toInt()
        }
      }
      ++i
    }
    return f[n][0]
  }
}
