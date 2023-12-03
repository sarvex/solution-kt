import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList
import kotlin.collections.List

internal class Solution {
  fun countSteppingNumbers(low: Int, high: Int): List<Int> {
    val ans: List<Int> = ArrayList()
    if (low == 0) {
      ans.add(0)
    }
    val q: Deque<Long> = ArrayDeque()
    for (i in 1..9) {
      q.offer(i.toLong())
    }
    while (!q.isEmpty()) {
      val v = q.pollFirst()
      if (v > high) {
        break
      }
      if (v >= low) {
        ans.add(v.toInt())
      }
      val x = v.toInt() % 10
      if (x > 0) {
        q.offer(v * 10 + x - 1)
      }
      if (x < 9) {
        q.offer(v * 10 + x + 1)
      }
    }
    return ans
  }
}
