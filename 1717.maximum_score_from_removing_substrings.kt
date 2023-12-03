import java.util.*
import kotlin.collections.ArrayDeque

class Solution {
  fun maximumGain(s: String, x: Int, y: Int): Int {
    if (x < y) {
      return maximumGain(StringBuilder(s).reverse().toString(), y, x)
    }
    var ans = 0
    val stk1: Deque<Char> = ArrayDeque()
    val stk2: Deque<Char> = ArrayDeque()
    for (c in s.toCharArray()) {
      if (c != 'b') {
        stk1.push(c)
      } else {
        if (!stk1.isEmpty() && stk1.peek() === 'a') {
          stk1.pop()
          ans += x
        } else {
          stk1.push(c)
        }
      }
    }
    while (!stk1.isEmpty()) {
      val c = stk1.pop()
      if (c != 'b') {
        stk2.push(c)
      } else {
        if (!stk2.isEmpty() && stk2.peek() === 'a') {
          stk2.pop()
          ans += y
        } else {
          stk2.push(c)
        }
      }
    }
    return ans
  }
}
