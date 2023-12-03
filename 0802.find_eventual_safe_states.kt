internal class Solution {
  private var color: IntArray
  private var g: Array<IntArray>
  fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
    val n = graph.size
    color = IntArray(n)
    g = graph
    val ans: List<Int> = ArrayList()
    for (i in 0 until n) {
      if (dfs(i)) {
        ans.add(i)
      }
    }
    return ans
  }

  private fun dfs(i: Int): Boolean {
    if (color[i] > 0) {
      return color[i] == 2
    }
    color[i] = 1
    for (j in g[i]) {
      if (!dfs(j)) {
        return false
      }
    }
    color[i] = 2
    return true
  }
}
