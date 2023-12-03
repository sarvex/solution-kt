import java.util.Deque
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList
import kotlin.collections.List

class Solution {
  fun checkIfPrerequisite(n: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
    val f = Array(n) { BooleanArray(n) }
    val g: Array<List<Int>?> = arrayOfNulls(n)
    val indeg = IntArray(n)
    Arrays.setAll(g) { i -> ArrayList() }
    for (p in prerequisites) {
      g[p[0]].add(p[1])
      ++indeg[p[1]]
    }
    val q: Deque<Int> = ArrayDeque()
    for (i in 0 until n) {
      if (indeg[i] == 0) {
        q.offer(i)
      }
    }
    while (!q.isEmpty()) {
      val i = q.poll()
      for (j in g[i]!!) {
        f[i][j] = true
        for (h in 0 until n) {
          f[h][j] = f[h][j] or f[h][i]
        }
        if (--indeg[j] == 0) {
          q.offer(j)
        }
      }
    }
    val ans: List<Boolean> = ArrayList()
    for (qry in queries) {
      ans.add(f[qry[0]][qry[1]])
    }
    return ans
  }
}
