internal class Solution {
  fun construct(grid: Array<IntArray>): Node {
    return dfs(0, 0, grid.size - 1, grid[0].size - 1, grid)
  }

  private fun dfs(a: Int, b: Int, c: Int, d: Int, grid: Array<IntArray>): Node {
    var zero = 0
    var one = 0
    for (i in a..c) {
      for (j in b..d) {
        if (grid[i][j] == 0) {
          zero = 1
        } else {
          one = 1
        }
      }
    }
    val isLeaf = zero + one == 1
    val `val` = isLeaf && one == 1
    val node = Node(`val`, isLeaf.toInt())
    if (isLeaf) {
      return node
    }
    node.topLeft = dfs(a, b, (a + c) / 2, (b + d) / 2, grid)
    node.topRight = dfs(a, (b + d) / 2 + 1, (a + c) / 2, d, grid)
    node.bottomLeft = dfs((a + c) / 2 + 1, b, c, (b + d) / 2, grid)
    node.bottomRight = dfs((a + c) / 2 + 1, (b + d) / 2 + 1, c, d, grid)
    return node
  }
}
