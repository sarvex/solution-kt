internal class Solution {
  fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    val m = matrix.size
    val n = matrix[0].size
    val dirs = intArrayOf(0, 1, 0, -1, 0)
    var i = 0
    var j = 0
    var k = 0
    val ans: List<Int> = ArrayList()
    val vis = Array(m) { BooleanArray(n) }
    for (h in m * n downTo 1) {
      ans.add(matrix[i][j])
      vis[i][j] = true
      val x = i + dirs[k]
      val y = j + dirs[k + 1]
      if (x < 0 || x >= m || y < 0 || y >= n || vis[x][y]) {
        k = (k + 1) % 4
      }
      i += dirs[k]
      j += dirs[k + 1]
    }
    return ans
  }
}
