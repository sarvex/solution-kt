import java.util.*
import kotlin.collections.ArrayDeque

class Solution {
  fun boxDelivering(boxes: Array<IntArray>, portsCount: Int, maxBoxes: Int, maxWeight: Int): Int {
    val n = boxes.size
    val ws = LongArray(n + 1)
    val cs = IntArray(n)
    for (i in 0 until n) {
      val p = boxes[i][0]
      val w = boxes[i][1]
      ws[i + 1] = ws[i] + w
      if (i < n - 1) {
        cs[i + 1] = cs[i] + if (p != boxes[i + 1][0]) 1 else 0
      }
    }
    val f = IntArray(n + 1)
    val q: Deque<Int> = ArrayDeque()
    q.offer(0)
    for (i in 1..n) {
      while (!q.isEmpty()
        && (i - q.peekFirst() > maxBoxes || ws[i] - ws[q.peekFirst()] > maxWeight)
      ) {
        q.pollFirst()
      }
      if (!q.isEmpty()) {
        f[i] = cs[i - 1] + f[q.peekFirst()] - cs[q.peekFirst()] + 2
      }
      if (i < n) {
        while (!q.isEmpty() && f[q.peekLast()] - cs[q.peekLast()] >= f[i] - cs[i]) {
          q.pollLast()
        }
        q.offer(i)
      }
    }
    return f[n]
  }
}
