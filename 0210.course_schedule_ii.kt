import java.util.Deque
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList
import kotlin.collections.List

internal class Solution {
  fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
    val g: Array<List<Int>?> = arrayOfNulls(numCourses)
    Arrays.setAll(g) { k -> ArrayList() }
    val indeg = IntArray(numCourses)
    for (p in prerequisites) {
      val a = p[0]
      val b = p[1]
      g[b].add(a)
      ++indeg[a]
    }
    val q: Deque<Int> = ArrayDeque()
    for (i in 0 until numCourses) {
      if (indeg[i] == 0) {
        q.offer(i)
      }
    }
    val ans = IntArray(numCourses)
    var cnt = 0
    while (!q.isEmpty()) {
      val i = q.poll()
      ans[cnt++] = i
      for (j in g[i]!!) {
        if (--indeg[j] == 0) {
          q.offer(j)
        }
      }
    }
    return if (cnt == numCourses) ans else IntArray(0)
  }
}
