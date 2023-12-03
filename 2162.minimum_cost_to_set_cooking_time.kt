import kotlin.math.min

class Solution {
  fun minCostSetTime(startAt: Int, moveCost: Int, pushCost: Int, targetSeconds: Int): Int {
    val m = targetSeconds / 60
    val s = targetSeconds % 60
    return min(
      f(m, s, startAt, moveCost, pushCost).toDouble(), f(m - 1, s + 60, startAt, moveCost, pushCost).toDouble()
    ).toInt()
  }

  private fun f(m: Int, s: Int, prev: Int, moveCost: Int, pushCost: Int): Int {
    var prev = prev
    if (m < 0 || m > 99 || s < 0 || s > 99) {
      return Int.MAX_VALUE
    }
    val arr = intArrayOf(m / 10, m % 10, s / 10, s % 10)
    var i = 0
    while (i < 4 && arr[i] == 0) {
      ++i
    }
    var t = 0
    while (i < 4) {
      if (arr[i] != prev) {
        t += moveCost
      }
      t += pushCost
      prev = arr[i]
      ++i
    }
    return t
  }
}
