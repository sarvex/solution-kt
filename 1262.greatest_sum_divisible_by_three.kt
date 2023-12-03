import kotlin.math.max

internal class Solution {
  fun maxSumDivThree(nums: IntArray): Int {
    val inf = 1 shl 30
    var f = intArrayOf(0, -inf, -inf)
    for (x in nums) {
      val g = f.clone()
      for (j in 0..2) {
        g[j] = max(f[j].toDouble(), (f[(j - x % 3 + 3) % 3] + x).toDouble()).toInt()
      }
      f = g
    }
    return f[0]
  }
}
