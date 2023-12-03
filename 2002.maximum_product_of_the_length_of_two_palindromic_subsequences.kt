import kotlin.math.max

internal class Solution {
  fun maxProduct(s: String): Int {
    val n = s.length
    val p = BooleanArray(1 shl n)
    Arrays.fill(p, true)
    for (k in 1 until (1 shl n)) {
      var i = 0
      var j = n - 1
      while (i < n) {
        while (i < j && k shr i and 1 == 0) {
          ++i
        }
        while (i < j && k shr j and 1 == 0) {
          --j
        }
        if (i < j && s[i] != s[j]) {
          p[k] = false
          break
        }
        ++i
        --j
      }
    }
    var ans = 0
    for (i in 1 until (1 shl n)) {
      if (p[i]) {
        val a = Integer.bitCount(i)
        val mx = (1 shl n) - 1 xor i
        var j = mx
        while (j > 0) {
          if (p[j]) {
            val b = Integer.bitCount(j)
            ans = max(ans.toDouble(), (a * b).toDouble()).toInt()
          }
          j = j - 1 and mx
        }
      }
    }
    return ans
  }
}
