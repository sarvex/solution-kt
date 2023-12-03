internal class Solution {
  private var board: Array<CharArray>
  private var m = 0
  private var n = 0
  fun solve(board: Array<CharArray>) {
    m = board.size
    n = board[0].size
    this.board = board
    for (i in 0 until m) {
      for (j in 0 until n) {
        if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
          dfs(i, j)
        }
      }
    }
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (board[i][j] == '.') {
          board[i][j] = 'O'
        } else if (board[i][j] == 'O') {
          board[i][j] = 'X'
        }
      }
    }
  }

  private fun dfs(i: Int, j: Int) {
    board[i][j] = '.'
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    for (k in 0..3) {
      val x = i + dirs[k]
      val y = j + dirs[k + 1]
      if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {
        dfs(x, y)
      }
    }
  }
}
