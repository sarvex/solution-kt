import java.util.Deque
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList
import kotlin.collections.List

internal class Solution {
  fun shortestAlternatingPaths(n: Int, redEdges: Array<IntArray>, blueEdges: Array<IntArray>): IntArray {
    val g: Array<Array<List<Int>?>> = Array<Array<List?>>(2) { arrayOfNulls(n) }
    for (f in g) {
      Arrays.setAll(f) { k -> ArrayList() }
    }
    for (e in redEdges) {
      g[0][e[0]].add(e[1])
    }
    for (e in blueEdges) {
      g[1][e[0]].add(e[1])
    }
    val q: Deque<IntArray> = ArrayDeque()
    q.offer(intArrayOf(0, 0))
    q.offer(intArrayOf(0, 1))
    val vis = Array(n) { BooleanArray(2) }
    val ans = IntArray(n)
    Arrays.fill(ans, -1)
    var d = 0
    while (!q.isEmpty()) {
      for (k in q.size() downTo 1) {
        val p: Unit = q.poll()
        val i: Int = p.get(0)
        var c: Int = p.get(1)
        if (ans[i] == -1) {
          ans[i] = d
        }
        vis[i][c] = true
        c = c xor 1
        for (j in g[c][i]!!) {
          if (!vis[j][c]) {
            q.offer(intArrayOf(j, c))
          }
        }
      }
      ++d
    }
    return ans
  }
}
