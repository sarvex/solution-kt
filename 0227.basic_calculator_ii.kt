import java.util.*
import kotlin.collections.ArrayDeque

internal class Solution {
  fun calculate(s: String): Int {
    val stk: Deque<Int> = ArrayDeque()
    var sign = '+'
    var v = 0
    for (i in 0 until s.length) {
      val c = s[i]
      if (Character.isDigit(c)) {
        v = v * 10 + (c.code - '0'.code)
      }
      if (i == s.length - 1 || c == '+' || c == '-' || c == '*' || c == '/') {
        if (sign == '+') {
          stk.push(v)
        } else if (sign == '-') {
          stk.push(-v)
        } else if (sign == '*') {
          stk.push(stk.pop() * v)
        } else {
          stk.push(stk.pop() / v)
        }
        sign = c
        v = 0
      }
    }
    var ans = 0
    while (!stk.isEmpty()) {
      ans += stk.pop()
    }
    return ans
  }
}
