import kotlin.math.abs

internal class Solution {
  fun candyCrush(board: Array<IntArray>): Array<IntArray> {
    val m = board.size
    val n = board[0].size
    var run = true
    while (run) {
      run = false
      for (i in 0 until m) {
        for (j in 0 until n - 2) {
          if (board[i][j] != 0 && abs(board[i][j].toDouble()) == abs(board[i][j + 1].toDouble()) && abs(board[i][j].toDouble()) == abs(
              board[i][j + 2].toDouble()
            )
          ) {
            run = true
            board[i][j + 2] = (-abs(board[i][j].toDouble())).toInt()
            board[i][j + 1] = board[i][j + 2]
            board[i][j] = board[i][j + 1]
          }
        }
      }
      for (j in 0 until n) {
        for (i in 0 until m - 2) {
          if (board[i][j] != 0 && abs(board[i][j].toDouble()) == abs(board[i + 1][j].toDouble()) && abs(board[i][j].toDouble()) == abs(
              board[i + 2][j].toDouble()
            )
          ) {
            run = true
            board[i + 2][j] = (-abs(board[i][j].toDouble())).toInt()
            board[i + 1][j] = board[i + 2][j]
            board[i][j] = board[i + 1][j]
          }
        }
      }
      if (run) {
        for (j in 0 until n) {
          var curr = m - 1
          for (i in m - 1 downTo 0) {
            if (board[i][j] > 0) {
              board[curr][j] = board[i][j]
              --curr
            }
          }
          while (curr > -1) {
            board[curr][j] = 0
            --curr
          }
        }
      }
    }
    return board
  }
}
