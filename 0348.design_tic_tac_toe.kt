internal class TicTacToe(private val n: Int) {
  private val counter: Array<IntArray>

  /** Initialize your data structure here.  */
  init {
    counter = Array(2) { IntArray((n shl 1) + 2) }
  }

  /**
   * Player {player} makes a move at ({row}, {col}).
   * @param row The row of the board.
   * @param col The column of the board.
   * @param player The player, can be either 1 or 2.
   * @return The current winning condition, can be either:
   * 0: No one wins.
   * 1: Player 1 wins.
   * 2: Player 2 wins.
   */
  fun move(row: Int, col: Int, player: Int): Int {
    counter[player - 1][row] += 1
    counter[player - 1][col + n] += 1
    if (row == col) {
      counter[player - 1][n shl 1] += 1
    }
    if (row + col == n - 1) {
      counter[player - 1][(n shl 1) + 1] += 1
    }
    return if (counter[player - 1][row] == n || counter[player - 1][col + n] == n || counter[player - 1][n shl 1] == n || counter[player - 1][(n shl 1) + 1] == n) {
      player
    } else 0
  }
}
