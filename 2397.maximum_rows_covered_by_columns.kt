import kotlin.math.max

class Solution {
  fun maximumRows(matrix: Array<IntArray>, numSelect: Int): Int {
    val m = matrix.size
    val n = matrix[0].size
    val rows = IntArray(m)
    for (i in 0 until m) {
      for (j in 0 until n) {
        if (matrix[i][j] == 1) {
          rows[i] = rows[i] or (1 shl j)
        }
      }
    }
    var ans = 0
    for (mask in 1 until (1 shl n)) {
      if (Integer.bitCount(mask) != numSelect) {
        continue
      }
      var t = 0
      for (x in rows) {
        if (x and mask == x) {
          ++t
        }
      }
      ans = max(ans.toDouble(), t.toDouble()).toInt()
    }
    return ans
  }
}
