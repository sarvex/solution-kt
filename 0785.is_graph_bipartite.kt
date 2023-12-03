internal class Solution {
  private var color: IntArray
  private var g: Array<IntArray>
  fun isBipartite(graph: Array<IntArray>): Boolean {
    val n = graph.size
    color = IntArray(n)
    g = graph
    for (i in 0 until n) {
      if (color[i] == 0 && !dfs(i, 1)) {
        return false
      }
    }
    return true
  }

  private fun dfs(u: Int, c: Int): Boolean {
    color[u] = c
    for (v in g[u]) {
      if (color[v] == 0) {
        if (!dfs(v, 3 - c)) {
          return false
        }
      } else if (color[v] == c) {
        return false
      }
    }
    return true
  }
}
