class Solution {
  fun numRookCaptures(board: Array<CharArray>): Int {
    var ans = 0
    val dirs = intArrayOf(-1, 0, 1, 0, -1)
    for (i in 0..7) {
      for (j in 0..7) {
        if (board[i][j] == 'R') {
          for (k in 0..3) {
            var x = i
            var y = j
            val a = dirs[k]
            val b = dirs[k + 1]
            while (x + a >= 0 && x + a < 8 && y + b >= 0 && y + b < 8 && board[x + a][y + b] != 'B') {
              x += a
              y += b
              if (board[x][y] == 'p') {
                ++ans
                break
              }
            }
          }
        }
      }
    }
    return ans
  }
}
