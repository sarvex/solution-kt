import java.util.Deque
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList
import kotlin.collections.List

internal class Solution {
  fun minimumSemesters(n: Int, relations: Array<IntArray>): Int {
    var n = n
    val g: Array<List<Int>?> = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    val indeg = IntArray(n)
    for (r in relations) {
      val prev = r[0] - 1
      val nxt = r[1] - 1
      g[prev].add(nxt)
      ++indeg[nxt]
    }
    val q: Deque<Int> = ArrayDeque()
    for (i in 0 until n) {
      if (indeg[i] == 0) {
        q.offer(i)
      }
    }
    var ans = 0
    while (!q.isEmpty()) {
      ++ans
      for (k in q.size() downTo 1) {
        val i = q.poll()
        --n
        for (j in g[i]!!) {
          if (--indeg[j] == 0) {
            q.offer(j)
          }
        }
      }
    }
    return if (n == 0) ans else -1
  }
}
