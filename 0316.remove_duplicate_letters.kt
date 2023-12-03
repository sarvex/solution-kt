import java.util.*
import kotlin.collections.ArrayDeque

internal class Solution {
  fun removeDuplicateLetters(s: String): String {
    val n = s.length
    val last = IntArray(26)
    for (i in 0 until n) {
      last[s[i].code - 'a'.code] = i
    }
    val stk: Deque<Char> = ArrayDeque()
    var mask = 0
    for (i in 0 until n) {
      val c = s[i]
      if (mask shr c.code - 'a'.code and 1 == 1) {
        continue
      }
      while (!stk.isEmpty() && stk.peek() > c && last[stk.peek() - 'a'] > i) {
        mask = mask xor (1 shl stk.pop() - 'a')
      }
      stk.push(c)
      mask = mask or (1 shl c.code - 'a'.code)
    }
    val ans = StringBuilder()
    for (c in stk) {
      ans.append(c)
    }
    return ans.reverse().toString()
  }
}
