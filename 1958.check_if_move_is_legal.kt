class Solution {
  fun checkMove(board: Array<CharArray>, rMove: Int, cMove: Int, color: Char): Boolean {
    for (d in Solution.Companion.DIRS) {
      var i = rMove
      var j = cMove
      var t = 0
      val a = d[0]
      val b = d[1]
      while (0 <= i + a && i + a < Solution.Companion.N && 0 <= j + b && j + b < Solution.Companion.N) {
        ++t
        i += a
        j += b
        if (board[i][j] == '.' || board[i][j] == color) {
          break
        }
      }
      if (board[i][j] == color && t > 1) {
        return true
      }
    }
    return false
  }

  companion object {
    private val DIRS = arrayOf(
      intArrayOf(1, 0),
      intArrayOf(0, 1),
      intArrayOf(-1, 0),
      intArrayOf(0, -1),
      intArrayOf(1, 1),
      intArrayOf(1, -1),
      intArrayOf(-1, 1),
      intArrayOf(-1, -1)
    )
    private const val N = 8
  }
}
