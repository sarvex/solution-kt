import kotlin.math.max
import kotlin.math.min

class Solution {
  fun calculateTax(brackets: Array<IntArray>, income: Int): Double {
    var ans = 0
    var prev = 0
    for (e in brackets) {
      val upper = e[0]
      val percent = e[1]
      (ans += max(0.0, (min(income.toDouble(), upper.toDouble()) - prev).toDouble()) * percent).toInt()
      prev = upper
    }
    return ans / 100.0
  }
}
