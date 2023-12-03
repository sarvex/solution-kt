import kotlin.math.min

internal class Solution {
  fun coinChange(coins: IntArray, amount: Int): Int {
    val inf = 1 shl 30
    val f = IntArray(amount + 1)
    Arrays.fill(f, inf)
    f[0] = 0
    for (x in coins) {
      for (j in x..amount) {
        f[j] = min(f[j].toDouble(), (f[j - x] + 1).toDouble()).toInt()
      }
    }
    return if (f[amount] >= inf) -1 else f[amount]
  }
}
