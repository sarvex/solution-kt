import kotlin.math.min

class Solution {
  fun minimumFinishTime(tires: Array<IntArray>, changeTime: Int, numLaps: Int): Int {
    val inf = 1 shl 30
    val cost = IntArray(18)
    Arrays.fill(cost, inf)
    for (e in tires) {
      val f = e[0]
      val r = e[1]
      var s = 0
      var t = f
      var i = 1
      while (t <= changeTime + f) {
        s += t
        cost[i] = min(cost[i].toDouble(), s.toDouble()).toInt()
        t *= r
        ++i
      }
    }
    val f = IntArray(numLaps + 1)
    Arrays.fill(f, inf)
    f[0] = -changeTime
    for (i in 1..numLaps) {
      for (j in 1 until min(18.0, (i + 1).toDouble()).toInt()) {
        f[i] = min(f[i].toDouble(), (f[i - j] + cost[j]).toDouble()).toInt()
      }
      f[i] += changeTime
    }
    return f[numLaps]
  }
}
