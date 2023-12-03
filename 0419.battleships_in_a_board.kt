internal class Solution {
  fun countBattleships(board: Array<CharArray>): Int {
    val m = board.size
    val n = board[0].size
    var ans = 0
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (board[i][j] == '.') {
          continue
        }
        if (i > 0 && board[i - 1][j] == 'X') {
          continue
        }
        if (j > 0 && board[i][j - 1] == 'X') {
          continue
        }
        ++ans
      }
    }
    return ans
  }
}
