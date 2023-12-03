internal class Solution {
  private var m = 0
  private var n = 0
  private var word: String? = null
  private var board: Array<CharArray>
  fun exist(board: Array<CharArray>, word: String?): Boolean {
    m = board.size
    n = board[0].size
    this.word = word
    this.board = board
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (dfs(i, j, 0)) {
          return true
        }
      }
    }
    return false
  }

  private fun dfs(i: Int, j: Int, k: Int): Boolean {
    if (k == word!!.length - 1) {
      return board[i][j] == word!![k]
    }
    if (board[i][j] != word!![k]) {
      return false
    }
    val c = board[i][j]
    board[i][j] = '0'
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    for (u in 0..3) {
      val x = i + dirs[u]
      val y = j + dirs[u + 1]
      if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] != '0' && dfs(x, y, k + 1)) {
        return true
      }
    }
    board[i][j] = c
    return false
  }
}
