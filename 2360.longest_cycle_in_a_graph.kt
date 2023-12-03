class Solution {
  fun longestCycle(edges: IntArray): Int {
    val n = edges.size
    val vis = BooleanArray(n)
    var ans = -1
    for (i in 0 until n) {
      if (vis[i]) {
        continue
      }
      var j = i
      val cycle: List<Int> = ArrayList()
      while (j != -1 && !vis[j]) {
        vis[j] = true
        cycle.add(j)
        j = edges[j]
      }
      if (j == -1) {
        continue
      }
      for (k in 0 until cycle.size()) {
        if (cycle[k] === j) {
          ans = Math.max(ans, cycle.size() - k)
          break
        }
      }
    }
    return ans
  }
}
