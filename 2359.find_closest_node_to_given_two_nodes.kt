import kotlin.math.max

class Solution {
  private var n = 0
  private var g: Array<List<Int>?>
  fun closestMeetingNode(edges: IntArray, node1: Int, node2: Int): Int {
    n = edges.size
    g = arrayOfNulls(n)
    Arrays.setAll(g) { k -> ArrayList() }
    for (i in 0 until n) {
      if (edges[i] != -1) {
        g[i].add(edges[i])
      }
    }
    val d1 = dijkstra(node1)
    val d2 = dijkstra(node2)
    var d = 1 shl 30
    var ans = -1
    for (i in 0 until n) {
      val t = max(d1[i].toDouble(), d2[i].toDouble()).toInt()
      if (t < d) {
        d = t
        ans = i
      }
    }
    return ans
  }

  private fun dijkstra(i: Int): IntArray {
    var i = i
    val dist = IntArray(n)
    Arrays.fill(dist, 1 shl 30)
    dist[i] = 0
    val q: PriorityQueue<IntArray> = PriorityQueue { a, b -> a.get(0) - b.get(0) }
    q.offer(intArrayOf(0, i))
    while (!q.isEmpty()) {
      val p: Unit = q.poll()
      i = p.get(1)
      for (j in g[i]!!) {
        if (dist[j] > dist[i] + 1) {
          dist[j] = dist[i] + 1
          q.offer(intArrayOf(dist[j], j))
        }
      }
    }
    return dist
  }
}
