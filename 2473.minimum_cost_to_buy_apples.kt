import kotlin.math.min

class Solution {
  private var k = 0
  private var cost: IntArray
  private var dist: IntArray
  private var g: Array<List<IntArray>?>
  fun minCost(n: Int, roads: Array<IntArray>, appleCost: IntArray, k: Int): LongArray {
    cost = appleCost
    g = arrayOfNulls(n)
    dist = IntArray(n)
    this.k = k
    for (i in 0 until n) {
      g[i] = ArrayList()
    }
    for (e in roads) {
      val a = e[0] - 1
      val b = e[1] - 1
      val c = e[2]
      g[a].add(intArrayOf(b, c))
      g[b].add(intArrayOf(a, c))
    }
    val ans = LongArray(n)
    for (i in 0 until n) {
      ans[i] = dijkstra(i)
    }
    return ans
  }

  private fun dijkstra(u: Int): Long {
    var u = u
    val q: PriorityQueue<IntArray> = PriorityQueue { a, b -> a.get(0) - b.get(0) }
    q.offer(intArrayOf(0, u))
    Arrays.fill(dist, Solution.Companion.INF)
    dist[u] = 0
    var ans = Long.MAX_VALUE
    while (!q.isEmpty()) {
      val p: Unit = q.poll()
      val d: Int = p.get(0)
      u = p.get(1)
      ans = min(ans.toDouble(), (cost[u] + (k + 1).toLong() * d).toDouble()).toLong()
      for (ne in g[u]!!) {
        val v = ne[0]
        val w = ne[1]
        if (dist[v] > dist[u] + w) {
          dist[v] = dist[u] + w
          q.offer(intArrayOf(dist[v], v))
        }
      }
    }
    return ans
  }

  companion object {
    private const val INF = 0x3f3f3f3f
  }
}
