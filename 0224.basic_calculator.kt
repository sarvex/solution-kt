import java.util.*
import kotlin.collections.ArrayDeque

internal class Solution {
  fun calculate(s: String): Int {
    val stk: Deque<Int> = ArrayDeque()
    var sign = 1
    var ans = 0
    val n = s.length
    var i = 0
    while (i < n) {
      val c = s[i]
      if (Character.isDigit(c)) {
        var j = i
        var x = 0
        while (j < n && Character.isDigit(s[j])) {
          x = x * 10 + s[j].code - '0'.code
          j++
        }
        ans += sign * x
        i = j - 1
      } else if (c == '+') {
        sign = 1
      } else if (c == '-') {
        sign = -1
      } else if (c == '(') {
        stk.push(ans)
        stk.push(sign)
        ans = 0
        sign = 1
      } else if (c == ')') {
        ans = stk.pop() * ans + stk.pop()
      }
      ++i
    }
    return ans
  }
}
