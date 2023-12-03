import java.util.Deque
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList
import kotlin.collections.List

internal class Solution {
  fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
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
    var cnt = 0
    while (!q.isEmpty()) {
      val i = q.poll()
      ++cnt
      for (j in g[i]!!) {
        if (--indeg[j] == 0) {
          q.offer(j)
        }
      }
    }
    return cnt == numCourses
  }
}
