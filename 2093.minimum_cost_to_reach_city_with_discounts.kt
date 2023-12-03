internal class Solution {
  fun minimumCost(n: Int, highways: Array<IntArray>, discounts: Int): Int {
    val g: Array<List<IntArray>?> = arrayOfNulls(n)
    for (i in 0 until n) {
      g[i] = ArrayList()
    }
    for (e in highways) {
      val a = e[0]
      val b = e[1]
      val c = e[2]
      g[a].add(intArrayOf(b, c))
      g[b].add(intArrayOf(a, c))
    }
    val q: PriorityQueue<IntArray> = PriorityQueue { a, b -> a.get(0) - b.get(0) }
    q.offer(intArrayOf(0, 0, 0))
    val dist = Array(n) { IntArray(discounts + 1) }
    for (e in dist) {
      Arrays.fill(e, Int.MAX_VALUE)
    }
    while (!q.isEmpty()) {
      val p: Unit = q.poll()
      val cost: Int = p.get(0)
      val i: Int = p.get(1)
      val k: Int = p.get(2)
      if (k > discounts || dist[i][k] <= cost) {
        continue
      }
      if (i == n - 1) {
        return cost
      }
      dist[i][k] = cost
      for (nxt in g[i]!!) {
        val j = nxt[0]
        val v = nxt[1]
        q.offer(intArrayOf(cost + v, j, k))
        q.offer(intArrayOf(cost + v / 2, j, k + 1))
      }
    }
    return -1
  }
}
