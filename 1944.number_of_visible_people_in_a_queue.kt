import java.util.*
import kotlin.collections.ArrayDeque

class Solution {
  fun canSeePersonsCount(heights: IntArray): IntArray {
    val n = heights.size
    val ans = IntArray(n)
    val stk: Deque<Int> = ArrayDeque()
    for (i in n - 1 downTo 0) {
      while (!stk.isEmpty() && stk.peek() < heights[i]) {
        stk.pop()
        ++ans[i]
      }
      if (!stk.isEmpty()) {
        ++ans[i]
      }
      stk.push(heights[i])
    }
    return ans
  }
}
