import kotlin.math.min

class Solution {
  fun minSideJumps(obstacles: IntArray): Int {
    val inf = 1 shl 30
    val f = intArrayOf(1, 0, 1)
    for (i in 1 until obstacles.size) {
      for (j in 0..2) {
        if (obstacles[i] == j + 1) {
          f[j] = inf
          break
        }
      }
      val x = (min(f[0].toDouble(), min(f[1].toDouble(), f[2].toDouble())) + 1).toInt()
      for (j in 0..2) {
        if (obstacles[i] != j + 1) {
          f[j] = min(f[j].toDouble(), x.toDouble()).toInt()
        }
      }
    }
    return min(f[0].toDouble(), min(f[1].toDouble(), f[2].toDouble())).toInt()
  }
}
