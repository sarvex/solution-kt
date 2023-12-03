import kotlin.math.abs
import kotlin.math.sqrt

class Solution {
  fun closestDivisors(num: Int): IntArray {
    val a = f(num + 1)
    val b = f(num + 2)
    return if (abs((a[0] - a[1]).toDouble()) < abs((b[0] - b[1]).toDouble())) a else b
  }

  private fun f(x: Int): IntArray {
    var i = sqrt(x.toDouble()).toInt()
    while (true) {
      if (x % i == 0) {
        return intArrayOf(i, x / i)
      }
      --i
    }
  }
}
