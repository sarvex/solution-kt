import kotlin.math.max

internal class Solution {
  fun longestValidParentheses(s: String): Int {
    val n = s.length
    val f = IntArray(n + 1)
    var ans = 0
    for (i in 2..n) {
      if (s[i - 1] == ')') {
        if (s[i - 2] == '(') {
          f[i] = f[i - 2] + 2
        } else {
          val j = i - f[i - 1] - 1
          if (j > 0 && s[j - 1] == '(') {
            f[i] = f[i - 1] + 2 + f[j - 1]
          }
        }
        ans = max(ans.toDouble(), f[i].toDouble()).toInt()
      }
    }
    return ans
  }
}
