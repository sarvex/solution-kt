import kotlin.math.min

internal class Solution {
  fun cheapestJump(coins: IntArray, maxJump: Int): List<Int> {
    val n = coins.size
    val ans: List<Int> = ArrayList()
    if (coins[n - 1] == -1) {
      return ans
    }
    val f = IntArray(n)
    val inf = 1 shl 30
    Arrays.fill(f, inf)
    f[n - 1] = coins[n - 1]
    for (i in n - 2 downTo 0) {
      if (coins[i] != -1) {
        for (j in i + 1 until min(n.toDouble(), (i + maxJump + 1).toDouble()).toInt()) {
          if (f[i] > f[j] + coins[i]) {
            f[i] = f[j] + coins[i]
          }
        }
      }
    }
    if (f[0] == inf) {
      return ans
    }
    var i = 0
    var s = f[0]
    while (i < n) {
      if (f[i] == s) {
        s -= coins[i]
        ans.add(i + 1)
      }
      ++i
    }
    return ans
  }
}
