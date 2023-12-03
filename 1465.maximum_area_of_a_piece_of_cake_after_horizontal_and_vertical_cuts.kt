import kotlin.math.max

class Solution {
  fun maxArea(h: Int, w: Int, horizontalCuts: IntArray, verticalCuts: IntArray): Int {
    val mod = 1e9.toInt() + 7
    Arrays.sort(horizontalCuts)
    Arrays.sort(verticalCuts)
    val m = horizontalCuts.size
    val n = verticalCuts.size
    var x = max(horizontalCuts[0].toDouble(), (h - horizontalCuts[m - 1]).toDouble()).toLong()
    var y = max(verticalCuts[0].toDouble(), (w - verticalCuts[n - 1]).toDouble()).toLong()
    for (i in 1 until m) {
      x = max(x.toDouble(), (horizontalCuts[i] - horizontalCuts[i - 1]).toDouble()).toLong()
    }
    for (i in 1 until n) {
      y = max(y.toDouble(), (verticalCuts[i] - verticalCuts[i - 1]).toDouble()).toLong()
    }
    return (x * y % mod).toInt()
  }
}
