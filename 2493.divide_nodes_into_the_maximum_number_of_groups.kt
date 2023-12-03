import kotlin.math.abs
import kotlin.math.max

class Solution {
  private var g: Array<List<Int>?>
  private val arr: List<Int> = ArrayList()
  private var vis: BooleanArray
  private var n = 0
  fun magnificentSets(n: Int, edges: Array<IntArray>): Int {
    g = arrayOfNulls(n + 1)
    this.n = n
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      g[b].add(a)
    }
    vis = BooleanArray(n + 1)
    var ans = 0
    for (i in 1..n) {
      if (!vis[i]) {
        dfs(i)
        var t = -1
        for (v in arr) {
          t = max(t.toDouble(), bfs(v).toDouble()).toInt()
        }
        if (t == -1) {
          return -1
        }
        ans += t
        arr.clear()
      }
    }
    return ans
  }

  private fun bfs(k: Int): Int {
    val dist = IntArray(n + 1)
    Arrays.fill(dist, 1 shl 30)
    dist[k] = 1
    val q: Deque<Int> = ArrayDeque()
    q.offer(k)
    var ans = 1
    while (!q.isEmpty()) {
      val i: Int = q.pollFirst()
      for (j in g[i]!!) {
        if (dist[j] == 1 shl 30) {
          dist[j] = dist[i] + 1
          ans = dist[j]
          q.offer(j)
        }
      }
    }
    for (i in arr) {
      if (dist[i] == 1 shl 30) {
        dist[i] = ++ans
      }
    }
    for (i in arr) {
      for (j in g[i]!!) {
        if (abs((dist[i] - dist[j]).toDouble()) != 1) {
          return -1
        }
      }
    }
    return ans
  }

  private fun dfs(i: Int) {
    arr.add(i)
    vis[i] = true
    for (j in g[i]!!) {
      if (!vis[j]) {
        dfs(j)
      }
    }
  }
}
