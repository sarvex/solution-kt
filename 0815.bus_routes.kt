internal class Solution {
  fun numBusesToDestination(routes: Array<IntArray>, source: Int, target: Int): Int {
    if (source == target) {
      return 0
    }
    val n = routes.size
    val s: Array<Set<Int>?> = arrayOfNulls(n)
    val g: Array<List<Int>?> = arrayOfNulls(n)
    Arrays.setAll(s) { k -> HashSet() }
    Arrays.setAll(g) { k -> ArrayList() }
    val d: Map<Int, List<Int>> = HashMap()
    for (i in 0 until n) {
      for (v in routes[i]) {
        s[i].add(v)
        d.computeIfAbsent(v) { k -> ArrayList() }.add(i)
      }
    }
    for (ids in d.values()) {
      val m: Int = ids.size()
      for (i in 0 until m) {
        for (j in i + 1 until m) {
          val a: Int = ids.get(i)
          val b: Int = ids.get(j)
          g[a].add(b)
          g[b].add(a)
        }
      }
    }
    val q: Deque<Int> = ArrayDeque()
    val vis: Set<Int> = HashSet()
    var ans = 1
    for (v in d[source]!!) {
      q.offer(v)
      vis.add(v)
    }
    while (!q.isEmpty()) {
      for (k in q.size() downTo 1) {
        val i: Int = q.pollFirst()
        if (s[i]!!.contains(target)) {
          return ans
        }
        for (j in g[i]!!) {
          if (!vis.contains(j)) {
            vis.add(j)
            q.offer(j)
          }
        }
      }
      ++ans
    }
    return -1
  }
}
