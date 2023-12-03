class Solution {
  private var n = 0
  private var g: Array<List<Int>?>
  private var ans: List<List<Int>>? = null
  fun getAncestors(n: Int, edges: Array<IntArray>): List<List<Int>> {
    g = arrayOfNulls(n)
    this.n = n
    Arrays.setAll(g) { i -> ArrayList() }
    for (e in edges) {
      g[e[0]].add(e[1])
    }
    ans = ArrayList()
    for (i in 0 until n) {
      ans.add(ArrayList())
    }
    for (i in 0 until n) {
      bfs(i)
    }
    return ans
  }

  private fun bfs(s: Int) {
    val q: Deque<Int> = ArrayDeque()
    q.offer(s)
    val vis = BooleanArray(n)
    vis[s] = true
    while (!q.isEmpty()) {
      val i: Int = q.poll()
      for (j in g[i]!!) {
        if (!vis[j]) {
          vis[j] = true
          q.offer(j)
          ans!![j].add(s)
        }
      }
    }
  }
}
