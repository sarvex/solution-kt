internal class Solution {
  fun secondMinimum(n: Int, edges: Array<IntArray>, time: Int, change: Int): Int {
    val g: Array<List<Int>?> = arrayOfNulls(n + 1)
    Arrays.setAll(g) { k -> ArrayList() }
    for (e in edges) {
      val u = e[0]
      val v = e[1]
      g[u].add(v)
      g[v].add(u)
    }
    val q: Deque<IntArray> = LinkedList()
    q.offerLast(intArrayOf(1, 0))
    val dist = Array(n + 1) { IntArray(2) }
    for (i in 0 until n + 1) {
      Arrays.fill(dist[i], Int.MAX_VALUE)
    }
    dist[1][1] = 0
    while (!q.isEmpty()) {
      val e: IntArray = q.pollFirst()
      val u = e[0]
      val d = e[1]
      for (v in g[u]!!) {
        if (d + 1 < dist[v][0]) {
          dist[v][0] = d + 1
          q.offerLast(intArrayOf(v, d + 1))
        } else if (dist[v][0] < d + 1 && d + 1 < dist[v][1]) {
          dist[v][1] = d + 1
          if (v == n) {
            break
          }
          q.offerLast(intArrayOf(v, d + 1))
        }
      }
    }
    var ans = 0
    for (i in 0 until dist[n][1]) {
      ans += time
      if (i < dist[n][1] - 1 && ans / change % 2 == 1) {
        ans = (ans + change) / change * change
      }
    }
    return ans
  }
}
