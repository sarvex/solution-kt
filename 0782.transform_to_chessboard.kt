import kotlin.math.abs
import kotlin.math.min

internal class Solution {
  private var n = 0
  fun movesToChessboard(board: Array<IntArray>): Int {
    n = board.size
    val mask = (1 shl n) - 1
    var rowMask = 0
    var colMask = 0
    for (i in 0 until n) {
      rowMask = rowMask or (board[0][i] shl i)
      colMask = colMask or (board[i][0] shl i)
    }
    val revRowMask = mask xor rowMask
    val revColMask = mask xor colMask
    var sameRow = 0
    var sameCol = 0
    for (i in 0 until n) {
      var curRowMask = 0
      var curColMask = 0
      for (j in 0 until n) {
        curRowMask = curRowMask or (board[i][j] shl j)
        curColMask = curColMask or (board[j][i] shl j)
      }
      if (curRowMask != rowMask && curRowMask != revRowMask) {
        return -1
      }
      if (curColMask != colMask && curColMask != revColMask) {
        return -1
      }
      sameRow += if (curRowMask == rowMask) 1 else 0
      sameCol += if (curColMask == colMask) 1 else 0
    }
    val t1 = f(rowMask, sameRow)
    val t2 = f(colMask, sameCol)
    return if (t1 == -1 || t2 == -1) -1 else t1 + t2
  }

  private fun f(mask: Int, cnt: Int): Int {
    val ones = Integer.bitCount(mask)
    return if (n % 2 == 1) {
      if (abs((n - ones * 2).toDouble()) != 1 || abs((n - cnt * 2).toDouble()) != 1) {
        return -1
      }
      if (ones == n / 2) {
        n / 2 - Integer.bitCount(mask and -0x55555556)
      } else n / 2 + 1 - Integer.bitCount(mask and 0x55555555)
    } else {
      if (ones != n / 2 || cnt != n / 2) {
        return -1
      }
      val cnt0 = n / 2 - Integer.bitCount(mask and -0x55555556)
      val cnt1 = n / 2 - Integer.bitCount(mask and 0x55555555)
      min(cnt0.toDouble(), cnt1.toDouble()).toInt()
    }
  }
}
