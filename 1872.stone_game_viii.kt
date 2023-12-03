import kotlin.math.max

class Solution {
  fun stoneGameVIII(stones: IntArray): Int {
    val n = stones.size
    for (i in 1 until n) {
      stones[i] += stones[i - 1]
    }
    var f = stones[n - 1]
    for (i in n - 2 downTo 1) {
      f = max(f.toDouble(), (stones[i] - f).toDouble()).toInt()
    }
    return f
  }
}
