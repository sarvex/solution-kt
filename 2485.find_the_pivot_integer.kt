import kotlin.math.sqrt

class Solution {
  fun pivotInteger(n: Int): Int {
    val y = n * (n + 1) / 2
    val x = sqrt(y.toDouble()).toInt()
    return if (x * x == y) x else -1
  }
}
