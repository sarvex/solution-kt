import kotlin.math.max

class Solution {
  fun checkZeroOnes(s: String): Boolean {
    return f(s, '1') > f(s, '0')
  }

  private fun f(s: String, x: Char): Int {
    var cnt = 0
    var mx = 0
    for (i in 0 until s.length) {
      if (s[i] == x) {
        mx = max(mx.toDouble(), ++cnt.toDouble()).toInt()
      } else {
        cnt = 0
      }
    }
    return mx
  }
}
