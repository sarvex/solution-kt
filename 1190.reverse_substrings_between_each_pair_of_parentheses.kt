import java.util.*
import kotlin.collections.ArrayDeque

internal class Solution {
  fun reverseParentheses(s: String): String {
    val n = s.length
    val d = IntArray(n)
    val stk: Deque<Int> = ArrayDeque()
    for (i in 0 until n) {
      if (s[i] == '(') {
        stk.push(i)
      } else if (s[i] == ')') {
        val j = stk.pop()
        d[i] = j
        d[j] = i
      }
    }
    val ans = StringBuilder()
    var i = 0
    var x = 1
    while (i < n) {
      if (s[i] == '(' || s[i] == ')') {
        i = d[i]
        x = -x
      } else {
        ans.append(s[i])
      }
      i += x
    }
    return ans.toString()
  }
}
