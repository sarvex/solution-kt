import kotlin.math.max
import kotlin.math.min

internal class Solution {
  fun numMovesStonesII(stones: IntArray): IntArray {
    Arrays.sort(stones)
    val n = stones.size
    var mi = n
    val mx = (max(
      (stones[n - 1] - stones[1] + 1).toDouble(),
      (stones[n - 2] - stones[0] + 1).toDouble()
    ) - (n - 1)).toInt()
    var i = 0
    var j = 0
    while (j < n) {
      while (stones[j] - stones[i] + 1 > n) {
        ++i
      }
      mi = if (j - i + 1 == n - 1 && stones[j] - stones[i] == n - 2) {
        min(mi.toDouble(), 2.0).toInt()
      } else {
        min(mi.toDouble(), (n - (j - i + 1)).toDouble()).toInt()
      }
      ++j
    }
    return intArrayOf(mi, mx)
  }
}
