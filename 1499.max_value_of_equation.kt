import java.util.*
import kotlin.collections.ArrayDeque

class Solution {
  fun findMaxValueOfEquation(points: Array<IntArray>, k: Int): Int {
    var ans = -(1 shl 30)
    val q: Deque<IntArray> = ArrayDeque()
    for (p in points) {
      val x = p[0]
      val y = p[1]
      while (!q.isEmpty() && x - q.peekFirst()[0] > k) {
        q.pollFirst()
      }
      if (!q.isEmpty()) {
        ans = Math.max(ans, x + y + q.peekFirst()[1] - q.peekFirst()[0])
      }
      while (!q.isEmpty() && y - x >= q.peekLast()[1] - q.peekLast()[0]) {
        q.pollLast()
      }
      q.offerLast(p)
    }
    return ans
  }
}
