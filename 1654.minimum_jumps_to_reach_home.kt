import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList
import kotlin.collections.HashSet
import kotlin.collections.List
import kotlin.collections.Set

class Solution {
  fun minimumJumps(forbidden: IntArray, a: Int, b: Int, x: Int): Int {
    val s: Set<Int> = HashSet()
    for (v in forbidden) {
      s.add(v)
    }
    val q: Deque<IntArray> = ArrayDeque()
    q.offer(intArrayOf(0, 1))
    val n = 6000
    val vis = Array(n) { BooleanArray(2) }
    vis[0][1] = true
    var ans = 0
    while (!q.isEmpty()) {
      for (t in q.size() downTo 1) {
        val p: Unit = q.poll()
        val i: Int = p.get(0)
        var k: Int = p.get(1)
        if (i == x) {
          return ans
        }
        val nxt: List<IntArray> = ArrayList()
        nxt.add(intArrayOf(i + a, 1))
        if (k and 1 == 1) {
          nxt.add(intArrayOf(i - b, 0))
        }
        for (e in nxt) {
          val j = e[0]
          k = e[1]
          if (j >= 0 && j < n && !s.contains(j) && !vis[j][k]) {
            q.offer(intArrayOf(j, k))
            vis[j][k] = true
          }
        }
      }
      ++ans
    }
    return -1
  }
}
