internal class Solution {
  fun gameOfLife(board: Array<IntArray>) {
    val m = board.size
    val n = board[0].size
    for (i in 0 until m) {
      for (j in 0 until n) {
        var live = -board[i][j]
        for (x in i - 1..i + 1) {
          for (y in j - 1..j + 1) {
            if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] > 0) {
              ++live
            }
          }
        }
        if (board[i][j] == 1 && (live < 2 || live > 3)) {
          board[i][j] = 2
        }
        if (board[i][j] == 0 && live == 3) {
          board[i][j] = -1
        }
      }
    }
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (board[i][j] == 2) {
          board[i][j] = 0
        } else if (board[i][j] == -1) {
          board[i][j] = 1
        }
      }
    }
  }
}
