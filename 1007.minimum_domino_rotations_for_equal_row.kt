import kotlin.math.max
import kotlin.math.min

internal class Solution {
  private var n = 0
  private var tops: IntArray
  private var bottoms: IntArray
  fun minDominoRotations(tops: IntArray, bottoms: IntArray): Int {
    n = tops.size
    this.tops = tops
    this.bottoms = bottoms
    val ans = min(f(tops[0]).toDouble(), f(bottoms[0]).toDouble()).toInt()
    return if (ans > n) -1 else ans
  }

  private fun f(x: Int): Int {
    var cnt1 = 0
    var cnt2 = 0
    for (i in 0 until n) {
      if (tops[i] != x && bottoms[i] != x) {
        return n + 1
      }
      cnt1 += if (tops[i] == x) 1 else 0
      cnt2 += if (bottoms[i] == x) 1 else 0
    }
    return (n - max(cnt1.toDouble(), cnt2.toDouble())).toInt()
  }
}
