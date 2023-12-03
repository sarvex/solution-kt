import kotlin.math.max
import kotlin.math.min

internal class Solution {
  private var count: IntArray
  fun sampleStats(count: IntArray): DoubleArray {
    this.count = count
    var mi = 1 shl 30
    var mx = -1
    var s: Long = 0
    var cnt = 0
    var mode = 0
    for (k in count.indices) {
      if (count[k] > 0) {
        mi = min(mi.toDouble(), k.toDouble()).toInt()
        mx = max(mx.toDouble(), k.toDouble()).toInt()
        s += 1L * k * count[k]
        cnt += count[k]
        if (count[k] > count[mode]) {
          mode = k
        }
      }
    }
    val median = if (cnt % 2 == 1) find(cnt / 2 + 1).toDouble() else (find(cnt / 2) + find(cnt / 2 + 1)) / 2.0
    return doubleArrayOf(mi.toDouble(), mx.toDouble(), s * 1.0 / cnt, median, mode.toDouble())
  }

  private fun find(i: Int): Int {
    var k = 0
    var t = 0
    while (true) {
      t += count[k]
      if (t >= i) {
        return k
      }
      ++k
    }
  }
}
