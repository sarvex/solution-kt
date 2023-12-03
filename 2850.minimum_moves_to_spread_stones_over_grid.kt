import kotlin.math.abs
import kotlin.math.min

class Solution {
  fun minimumMoves(grid: Array<IntArray>): Int {
    val left: List<IntArray> = ArrayList()
    val right: List<IntArray> = ArrayList()
    for (i in 0..2) {
      for (j in 0..2) {
        if (grid[i][j] == 0) {
          left.add(intArrayOf(i, j))
        } else {
          for (k in 1 until grid[i][j]) {
            right.add(intArrayOf(i, j))
          }
        }
      }
    }
    val n: Int = left.size()
    val f = IntArray(1 shl n)
    Arrays.fill(f, 1 shl 30)
    f[0] = 0
    for (i in 1 until (1 shl n)) {
      val k = Integer.bitCount(i)
      for (j in 0 until n) {
        if (i shr j and 1 == 1) {
          f[i] = min(f[i].toDouble(), (f[i xor (1 shl j)] + cal(left[k - 1], right[j])).toDouble())
            .toInt()
        }
      }
    }
    return f[(1 shl n) - 1]
  }

  private fun cal(a: IntArray, b: IntArray): Int {
    return (abs((a[0] - b[0]).toDouble()) + abs((a[1] - b[1]).toDouble())).toInt()
  }
}
