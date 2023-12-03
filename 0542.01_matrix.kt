internal class Solution {
  fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
    val m = mat.size
    val n = mat[0].size
    val ans = Array(m) { IntArray(n) }
    for (row in ans) {
      Arrays.fill(row, -1)
    }
    val q: Deque<IntArray> = ArrayDeque()
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (mat[i][j] == 0) {
          q.offer(intArrayOf(i, j))
          ans[i][j] = 0
        }
      }
    }
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    while (!q.isEmpty()) {
      val p: IntArray = q.poll()
      val i = p[0]
      val j = p[1]
      for (k in 0..3) {
        val x = i + dirs[k]
        val y = j + dirs[k + 1]
        if (x >= 0 && x < m && y >= 0 && y < n && ans[x][y] == -1) {
          ans[x][y] = ans[i][j] + 1
          q.offer(intArrayOf(x, y))
        }
      }
    }
    return ans
  }
}
