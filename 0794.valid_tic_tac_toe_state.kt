internal class Solution {
  private var board: Array<String>
  fun validTicTacToe(board: Array<String>): Boolean {
    this.board = board
    val x = count('X')
    val o = count('O')
    if (x != o && x - 1 != o) {
      return false
    }
    return if (win('X') && x - 1 != o) {
      false
    } else !(win('O') && x != o)
  }

  private fun win(x: Char): Boolean {
    for (i in 0..2) {
      if (board[i][0] == x && board[i][1] == x && board[i][2] == x) {
        return true
      }
      if (board[0][i] == x && board[1][i] == x && board[2][i] == x) {
        return true
      }
    }
    return if (board[0][0] == x && board[1][1] == x && board[2][2] == x) {
      true
    } else board[0][2] == x && board[1][1] == x && board[2][0] == x
  }

  private fun count(x: Char): Int {
    var cnt = 0
    for (row in board) {
      for (c in row.toCharArray()) {
        if (c == x) {
          ++cnt
        }
      }
    }
    return cnt
  }
}
