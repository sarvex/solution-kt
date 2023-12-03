internal class Solution {
  private var m = 0
  private var n = 0
  private var board: Array<CharArray>
  private var word: String? = null
  private var k = 0
  fun placeWordInCrossword(board: Array<CharArray>, word: String): Boolean {
    m = board.size
    n = board[0].size
    this.board = board
    this.word = word
    k = word.length
    for (i in 0 until m) {
      for (j in 0 until n) {
        val leftToRight = (j == 0 || board[i][j - 1] == '#') && check(i, j, 0, 1)
        val rightToLeft = (j == n - 1 || board[i][j + 1] == '#') && check(i, j, 0, -1)
        val upToDown = (i == 0 || board[i - 1][j] == '#') && check(i, j, 1, 0)
        val downToUp = (i == m - 1 || board[i + 1][j] == '#') && check(i, j, -1, 0)
        if (leftToRight || rightToLeft || upToDown || downToUp) {
          return true
        }
      }
    }
    return false
  }

  private fun check(i: Int, j: Int, a: Int, b: Int): Boolean {
    var i = i
    var j = j
    val x = i + a * k
    val y = j + b * k
    if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] != '#') {
      return false
    }
    for (p in 0 until k) {
      if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != ' ' && board[i][j] != word!![p]) {
        return false
      }
      i += a
      j += b
    }
    return true
  }
}
