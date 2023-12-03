internal class Solution {
  private var board: Array<CharArray>
  private var m = 0
  private var n = 0
  fun updateBoard(board: Array<CharArray>, click: IntArray): Array<CharArray> {
    m = board.size
    n = board[0].size
    this.board = board
    val i = click[0]
    val j = click[1]
    if (board[i][j] == 'M') {
      board[i][j] = 'X'
    } else {
      dfs(i, j)
    }
    return board
  }

  private fun dfs(i: Int, j: Int) {
    var cnt = 0
    for (x in i - 1..i + 1) {
      for (y in j - 1..j + 1) {
        if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'M') {
          ++cnt
        }
      }
    }
    if (cnt > 0) {
      board[i][j] = (cnt + '0'.code).toChar()
    } else {
      board[i][j] = 'B'
      for (x in i - 1..i + 1) {
        for (y in j - 1..j + 1) {
          if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'E') {
            dfs(x, y)
          }
        }
      }
    }
  }
}
