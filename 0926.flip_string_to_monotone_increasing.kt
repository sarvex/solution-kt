import kotlin.math.min

internal class Solution {
  fun minFlipsMonoIncr(s: String): Int {
    val n = s.length
    val left = IntArray(n + 1)
    val right = IntArray(n + 1)
    var ans = Int.MAX_VALUE
    for (i in 1..n) {
      left[i] = left[i - 1] + if (s[i - 1] == '1') 1 else 0
    }
    for (i in n - 1 downTo 0) {
      right[i] = right[i + 1] + if (s[i] == '0') 1 else 0
    }
    for (i in 0..n) {
      ans = min(ans.toDouble(), (left[i] + right[i]).toDouble()).toInt()
    }
    return ans
  }
}
