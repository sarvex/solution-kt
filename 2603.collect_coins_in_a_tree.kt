class Solution {
  fun collectTheCoins(coins: IntArray, edges: Array<IntArray>): Int {
    val n = coins.size
    val g: Array<Set<Int>?> = arrayOfNulls(n)
    Arrays.setAll(g) { k -> HashSet() }
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      g[a].add(b)
      g[b].add(a)
    }
    val q: Deque<Int> = ArrayDeque()
    for (i in 0 until n) {
      if (coins[i] == 0 && g[i]!!.size() === 1) {
        q.offer(i)
      }
    }
    while (!q.isEmpty()) {
      val i: Int = q.poll()
      for (j in g[i]!!) {
        g[j].remove(i)
        if (coins[j] == 0 && g[j]!!.size() === 1) {
          q.offer(j)
        }
      }
      g[i].clear()
    }
    q.clear()
    for (k in 0..1) {
      for (i in 0 until n) {
        if (g[i]!!.size() === 1) {
          q.offer(i)
        }
      }
      for (i in q) {
        for (j in g[i]!!) {
          g[j].remove(i)
        }
        g[i].clear()
      }
    }
    var ans = 0
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      if (g[a]!!.size() > 0 && g[b]!!.size() > 0) {
        ans += 2
      }
    }
    return ans
  }
}
