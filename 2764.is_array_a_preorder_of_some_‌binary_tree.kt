class Solution {
  private val g: Map<Int, List<Int>> = HashMap()
  private var nodes: List<List<Int>>? = null
  private var k = 0
  fun isPreorder(nodes: List<List<Int>>): Boolean {
    this.nodes = nodes
    for (node in nodes) {
      g.computeIfAbsent(node[1]) { key -> ArrayList() }.add(node[0])
    }
    return dfs(nodes[0][0]) && k == nodes.size()
  }

  private fun dfs(i: Int): Boolean {
    if (i != nodes!![k][0]) {
      return false
    }
    ++k
    for (j in g[i] ?: List.of()) {
      if (!dfs(j)) {
        return false
      }
    }
    return true
  }
}
