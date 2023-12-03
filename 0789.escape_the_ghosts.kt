import kotlin.math.abs

internal class Solution {
  fun escapeGhosts(ghosts: Array<IntArray>, target: IntArray): Boolean {
    val tx = target[0]
    val ty = target[1]
    for (g in ghosts) {
      val x = g[0]
      val y = g[1]
      if (abs((tx - x).toDouble()) + abs((ty - y).toDouble()) <= abs(tx.toDouble()) + abs(ty.toDouble())) {
        return false
      }
    }
    return true
  }
}
