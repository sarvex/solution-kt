class Solution {
  private var board: List<String>? = null
  private var n = 0
  private var f: Array<IntArray>
  private var g: Array<IntArray>
  private val mod = 1e9.toInt() + 7
  fun pathsWithMaxScore(board: List<String>): IntArray {
    n = board.size()
    this.board = board
    f = Array(n) { IntArray(n) }
    g = Array(n) { IntArray(n) }
    for (e in f) {
      Arrays.fill(e, -1)
    }
    f[n - 1][n - 1] = 0
    g[n - 1][n - 1] = 1
    for (i in n - 1 downTo 0) {
      for (j in n - 1 downTo 0) {
        update(i, j, i + 1, j)
        update(i, j, i, j + 1)
        update(i, j, i + 1, j + 1)
        if (f[i][j] != -1) {
          val c: Char = board[i].charAt(j)
          if (c >= '0' && c <= '9') {
            f[i][j] += c.code - '0'.code
          }
        }
      }
    }
    val ans = IntArray(2)
    if (f[0][0] != -1) {
      ans[0] = f[0][0]
      ans[1] = g[0][0]
    }
    return ans
  }

  private fun update(i: Int, j: Int, x: Int, y: Int) {
    if (x >= n || y >= n || f[x][y] == -1 || board!![i].charAt(j) === 'X' || board!![i].charAt(j) === 'S') {
      return
    }
    if (f[x][y] > f[i][j]) {
      f[i][j] = f[x][y]
      g[i][j] = g[x][y]
    } else if (f[x][y] == f[i][j]) {
      g[i][j] = (g[i][j] + g[x][y]) % mod
    }
  }
}
