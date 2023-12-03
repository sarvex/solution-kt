internal class Solution {
  fun findAllPeople(n: Int, meetings: Array<IntArray>, firstPerson: Int): List<Int> {
    val vis = BooleanArray(n)
    vis[0] = true
    vis[firstPerson] = true
    val m = meetings.size
    Arrays.sort(meetings, Comparator.comparingInt { a -> a.get(2) })
    run {
      var i = 0
      while (i < m) {
        var j = i
        while (j + 1 < m && meetings[j + 1][2] == meetings[i][2]) {
          ++j
        }
        val g: Map<Int, List<Int>> = HashMap()
        val s: Set<Int> = HashSet()
        for (k in i..j) {
          val x = meetings[k][0]
          val y = meetings[k][1]
          g.computeIfAbsent(x) { key -> ArrayList() }.add(y)
          g.computeIfAbsent(y) { key -> ArrayList() }.add(x)
          s.add(x)
          s.add(y)
        }
        val q: Deque<Int> = ArrayDeque()
        for (u in s) {
          if (vis[u]) {
            q.offer(u)
          }
        }
        while (!q.isEmpty()) {
          val u: Int = q.poll()
          for (v in g[u] ?: Collections.emptyList()) {
            if (!vis[v]) {
              vis[v] = true
              q.offer(v)
            }
          }
        }
        i = j + 1
      }
    }
    val ans: List<Int> = ArrayList()
    for (i in 0 until n) {
      if (vis[i]) {
        ans.add(i)
      }
    }
    return ans
  }
}
