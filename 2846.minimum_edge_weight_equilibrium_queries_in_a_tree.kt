import kotlin.math.max

class Solution {
  fun minOperationsQueries(n: Int, edges: Array<IntArray>, queries: Array<IntArray>): IntArray {
    val m = 32 - Integer.numberOfLeadingZeros(n)
    val g: Array<List<IntArray>?> = arrayOfNulls(n)
    Arrays.setAll(g) { i -> ArrayList() }
    val f = Array(n) { IntArray(m) }
    val p = IntArray(n)
    val cnt = Array(n) { IntArray(0) }
    val depth = IntArray(n)
    for (e in edges) {
      val u = e[0]
      val v = e[1]
      val w = e[2] - 1
      g[u].add(intArrayOf(v, w))
      g[v].add(intArrayOf(u, w))
    }
    cnt[0] = IntArray(26)
    val q: Deque<Int> = ArrayDeque()
    q.offer(0)
    while (!q.isEmpty()) {
      val i: Int = q.poll()
      f[i][0] = p[i]
      for (j in 1 until m) {
        f[i][j] = f[f[i][j - 1]][j - 1]
      }
      for (nxt in g[i]!!) {
        val j = nxt[0]
        val w = nxt[1]
        if (j != p[i]) {
          p[j] = i
          cnt[j] = cnt[i].clone()
          cnt[j][w]++
          depth[j] = depth[i] + 1
          q.offer(j)
        }
      }
    }
    val k = queries.size
    val ans = IntArray(k)
    for (i in 0 until k) {
      val u = queries[i][0]
      val v = queries[i][1]
      var x = u
      var y = v
      if (depth[x] < depth[y]) {
        val t = x
        x = y
        y = t
      }
      for (j in m - 1 downTo 0) {
        if (depth[x] - depth[y] >= 1 shl j) {
          x = f[x][j]
        }
      }
      for (j in m - 1 downTo 0) {
        if (f[x][j] != f[y][j]) {
          x = f[x][j]
          y = f[y][j]
        }
      }
      if (x != y) {
        x = p[x]
      }
      var mx = 0
      for (j in 0..25) {
        mx = max(mx.toDouble(), (cnt[u][j] + cnt[v][j] - 2 * cnt[x][j]).toDouble())
          .toInt()
      }
      ans[i] = depth[u] + depth[v] - 2 * depth[x] - mx
    }
    return ans
  }
}
