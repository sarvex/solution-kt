internal class Solution {
  private var ok = false
  private var board: Array<CharArray>
  private val t: List<Int> = ArrayList()
  private val row = Array(9) { BooleanArray(9) }
  private val col = Array(9) { BooleanArray(9) }
  private val block = Array(3) { Array(3) { BooleanArray(9) } }
  fun solveSudoku(board: Array<CharArray>) {
    this.board = board
    for (i in 0..8) {
      for (j in 0..8) {
        if (board[i][j] == '.') {
          t.add(i * 9 + j)
        } else {
          val v = board[i][j].code - '1'.code
          block[i / 3][j / 3][v] = true
          col[j][v] = block[i / 3][j / 3][v]
          row[i][v] = col[j][v]
        }
      }
    }
    dfs(0)
  }

  private fun dfs(k: Int) {
    if (k == t.size()) {
      ok = true
      return
    }
    val i = t[k] / 9
    val j = t[k] % 9
    for (v in 0..8) {
      if (!row[i][v] && !col[j][v] && !block[i / 3][j / 3][v]) {
        block[i / 3][j / 3][v] = true
        col[j][v] = block[i / 3][j / 3][v]
        row[i][v] = col[j][v]
        board[i][j] = (v + '1'.code).toChar()
        dfs(k + 1)
        block[i / 3][j / 3][v] = false
        col[j][v] = block[i / 3][j / 3][v]
        row[i][v] = col[j][v]
      }
      if (ok) {
        return
      }
    }
  }
}
