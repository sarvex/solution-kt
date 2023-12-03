import kotlin.math.min

internal class Solution {
  fun stoneGameIX(stones: IntArray): Boolean {
    val c = IntArray(3)
    for (s in stones) {
      ++c[s % 3]
    }
    val t = intArrayOf(c[0], c[2], c[1])
    return check(c) || check(t)
  }

  private fun check(c: IntArray): Boolean {
    if (c[1] == 0) {
      return false
    }
    --c[1]
    var turn = (1 + min(c[1].toDouble(), c[2].toDouble()) * 2 + c[0]).toInt()
    if (c[1] > c[2]) {
      --c[1]
      ++turn
    }
    return turn % 2 == 1 && c[1] != c[2]
  }
}
