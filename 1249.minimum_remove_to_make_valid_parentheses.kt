import java.util.*
import kotlin.collections.ArrayDeque

internal class Solution {
  fun minRemoveToMakeValid(s: String): String {
    val stk: Deque<Char> = ArrayDeque()
    var x = 0
    for (i in 0 until s.length) {
      val c = s[i]
      if (c == ')' && x == 0) {
        continue
      }
      if (c == '(') {
        ++x
      } else if (c == ')') {
        --x
      }
      stk.push(c)
    }
    val ans = StringBuilder()
    x = 0
    while (!stk.isEmpty()) {
      val c = stk.pop()
      if (c == '(' && x == 0) {
        continue
      }
      if (c == ')') {
        ++x
      } else if (c == '(') {
        --x
      }
      ans.append(c)
    }
    return ans.reverse().toString()
  }
}
