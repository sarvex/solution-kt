import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.HashSet
import kotlin.collections.Set

class Solution {
  fun minNumberOfSemesters(n: Int, relations: Array<IntArray>, k: Int): Int {
    val d = IntArray(n + 1)
    for (e in relations) {
      d[e[1]] = d[e[1]] or (1 shl e[0])
    }
    val q: Deque<IntArray> = ArrayDeque()
    q.offer(intArrayOf(0, 0))
    val vis: Set<Int> = HashSet()
    vis.add(0)
    while (!q.isEmpty()) {
      val p: Unit = q.pollFirst()
      val cur: Int = p.get(0)
      val t: Int = p.get(1)
      if (cur == (1 shl n + 1) - 2) {
        return t
      }
      var nxt = 0
      for (i in 1..n) {
        if (cur and d[i] == d[i]) {
          nxt = nxt or (1 shl i)
        }
      }
      nxt = nxt xor cur
      if (Integer.bitCount(nxt) <= k) {
        if (vis.add(nxt or cur)) {
          q.offer(intArrayOf(nxt or cur, t + 1))
        }
      } else {
        val x = nxt
        while (nxt > 0) {
          if (Integer.bitCount(nxt) == k && vis.add(nxt or cur)) {
            q.offer(intArrayOf(nxt or cur, t + 1))
          }
          nxt = nxt - 1 and x
        }
      }
    }
    return 0
  }
}
