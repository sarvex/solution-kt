import java.util.*
import kotlin.collections.ArrayDeque

internal class Solution {
  fun isValid(s: String): Boolean {
    val stk: Deque<Char> = ArrayDeque()
    for (c in s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        stk.push(c)
      } else if (stk.isEmpty() || !match(stk.pop(), c)) {
        return false
      }
    }
    return stk.isEmpty()
  }

  private fun match(l: Char, r: Char): Boolean {
    return l == '(' && r == ')' || l == '{' && r == '}' || l == '[' && r == ']'
  }
}
