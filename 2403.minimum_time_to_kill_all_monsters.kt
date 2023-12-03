import kotlin.math.min

class Solution {
  private var n = 0
  private var f: LongArray
  private var power: IntArray
  fun minimumTime(power: IntArray): Long {
    n = power.size
    f = LongArray(1 shl n)
    Arrays.fill(f, -1)
    this.power = power
    return dfs(0)
  }

  private fun dfs(mask: Int): Long {
    if (f[mask] != -1L) {
      return f[mask]
    }
    val cnt = Integer.bitCount(mask)
    if (cnt == n) {
      return 0
    }
    var ans = Long.MAX_VALUE
    for (i in 0 until n) {
      if (mask shr i and 1 == 1) {
        continue
      }
      ans = min(ans.toDouble(), (dfs(mask or (1 shl i)) + (power[i] + cnt) / (cnt + 1)).toDouble())
        .toLong()
    }
    f[mask] = ans
    return ans
  }
}
