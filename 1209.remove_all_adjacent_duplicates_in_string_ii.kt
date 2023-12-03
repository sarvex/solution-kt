import java.util.*
import kotlin.collections.ArrayDeque

internal class Solution {
  fun removeDuplicates(s: String, k: Int): String {
    val stk: Deque<IntArray> = ArrayDeque()
    for (i in 0 until s.length) {
      val j = s[i].code - 'a'.code
      if (!stk.isEmpty() && stk.peek()[0] === j) {
        stk.peek()[1] = (stk.peek()[1] + 1) % k
        if (stk.peek()[1] === 0) {
          stk.pop()
        }
      } else {
        stk.push(intArrayOf(j, 1))
      }
    }
    val ans = StringBuilder()
    for (e in stk) {
      val c = (e[0] + 'a') as Char
      for (i in 0 until e[1]) {
        ans.append(c)
      }
    }
    ans.reverse()
    return ans.toString()
  }
}
