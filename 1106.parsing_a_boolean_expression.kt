import java.util.*
import kotlin.collections.ArrayDeque

internal class Solution {
  fun parseBoolExpr(expression: String): Boolean {
    val stk: Deque<Char> = ArrayDeque()
    for (c in expression.toCharArray()) {
      if (c != '(' && c != ')' && c != ',') {
        stk.push(c)
      } else if (c == ')') {
        var t = 0
        var f = 0
        while (stk.peek() === 't' || stk.peek() === 'f') {
          t += if (stk.peek() === 't') 1 else 0
          f += if (stk.peek() === 'f') 1 else 0
          stk.pop()
        }
        val op = stk.pop()
        c = 'f'
        if (op == '!' && f > 0 || op == '&' && f == 0 || op == '|' && t > 0) {
          c = 't'
        }
        stk.push(c)
      }
    }
    return stk.peek() === 't'
  }
}
