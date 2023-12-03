import java.util.Deque
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList
import kotlin.collections.List

class Solution {
  fun frogPosition(n: Int, edges: Array<IntArray>, t: Int, target: Int): Double {
    var t = t
    val g: Array<List<Int>?> = arrayOfNulls(n + 1)
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in edges) {
      val u = e[0]
      val v = e[1]
      g[u].add(v)
      g[v].add(u)
    }
    val q: Deque<Pair<Int, Double>> = ArrayDeque()
    q.offer(Pair(1, 1.0.toInt()))
    val vis = BooleanArray(n + 1)
    vis[1] = true
    while (!q.isEmpty() && t >= 0) {
      for (k in q.size() downTo 1) {
        val x: Unit = q.poll()
        val u: Int = x.getKey()
        val p: Double = x.getValue()
        val cnt: Int = g[u]!!.size() - if (u == 1) 0 else 1
        if (u == target) {
          return if (cnt * t == 0) p else 0
        }
        for (v in g[u]!!) {
          if (!vis[v]) {
            vis[v] = true
            q.offer(Pair(v, (p / cnt).toInt()))
          }
        }
      }
      --t
    }
    return 0
  }
}
