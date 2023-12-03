import java.util.*
import kotlin.collections.ArrayDeque

internal class Solution {
  fun parseTernary(expression: String): String {
    val stk: Deque<Char> = ArrayDeque()
    var cond = false
    for (i in expression.length - 1 downTo 0) {
      val c = expression[i]
      if (c == ':') {
        continue
      }
      if (c == '?') {
        cond = true
      } else {
        if (cond) {
          if (c == 'T') {
            val x = stk.pop()
            stk.pop()
            stk.push(x)
          } else {
            stk.pop()
          }
          cond = false
        } else {
          stk.push(c)
        }
      }
    }
    return java.lang.String.valueOf(stk.peek())
  }
}
