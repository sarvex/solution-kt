internal class Solution {
  fun isValidSudoku(board: Array<CharArray>): Boolean {
    val row = Array(9) { BooleanArray(9) }
    val col = Array(9) { BooleanArray(9) }
    val sub = Array(9) { BooleanArray(9) }
    for (i in 0..8) {
      for (j in 0..8) {
        val c = board[i][j]
        if (c == '.') {
          continue
        }
        val num = c.code - '0'.code - 1
        val k = i / 3 * 3 + j / 3
        if (row[i][num] || col[j][num] || sub[k][num]) {
          return false
        }
        row[i][num] = true
        col[j][num] = true
        sub[k][num] = true
      }
    }
    return true
  }
}
