internal class Solution {
  fun shortestPathLength(graph: Array<IntArray>): Int {
    val n = graph.size
    val q: Deque<IntArray> = ArrayDeque()
    val vis = Array(n) { BooleanArray(1 shl n) }
    for (i in 0 until n) {
      q.offer(intArrayOf(i, 1 shl i))
      vis[i][1 shl i] = true
    }
    var ans = 0
    while (true) {
      for (k in q.size() downTo 1) {
        val p: Unit = q.poll()
        val i: Int = p.get(0)
        val st: Int = p.get(1)
        if (st == (1 shl n) - 1) {
          return ans
        }
        for (j in graph[i]) {
          val nst = st or (1 shl j)
          if (!vis[j][nst]) {
            vis[j][nst] = true
            q.offer(intArrayOf(j, nst))
          }
        }
      }
      ++ans
    }
  }
}
