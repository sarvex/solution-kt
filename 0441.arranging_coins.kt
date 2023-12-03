import kotlin.math.sqrt

internal class Solution {
  fun arrangeCoins(n: Int): Int {
    return (sqrt(2.0) * sqrt(n + 0.125) - 0.5).toInt()
  }
}
