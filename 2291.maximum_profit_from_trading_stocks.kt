import kotlin.math.max

class Solution {
  fun maximumProfit(present: IntArray, future: IntArray, budget: Int): Int {
    val n = present.size
    val f = IntArray(budget + 1)
    for (i in 0 until n) {
      val a = present[i]
      val b = future[i]
      for (j in budget downTo a) {
        f[j] = max(f[j].toDouble(), (f[j - a] + b - a).toDouble()).toInt()
      }
    }
    return f[budget]
  }
}
