import kotlin.math.sqrt

class Solution {
  fun countTriples(n: Int): Int {
    var res = 0
    for (a in 1..n) {
      for (b in 1..n) {
        val t = a * a + b * b
        val c = sqrt(t.toDouble()).toInt()
        if (c <= n && c * c == t) {
          ++res
        }
      }
    }
    return res
  }
}
