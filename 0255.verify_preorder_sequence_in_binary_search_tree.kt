import java.util.*
import kotlin.collections.ArrayDeque

internal class Solution {
  fun verifyPreorder(preorder: IntArray): Boolean {
    val stk: Deque<Int> = ArrayDeque()
    var last = Int.MIN_VALUE
    for (x in preorder) {
      if (x < last) {
        return false
      }
      while (!stk.isEmpty() && stk.peek() < x) {
        last = stk.poll()
      }
      stk.push(x)
    }
    return true
  }
}
