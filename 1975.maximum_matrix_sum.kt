import kotlin.math.abs
import kotlin.math.min

class Solution {
  fun maxMatrixSum(matrix: Array<IntArray>): Long {
    var s: Long = 0
    var cnt = 0
    var mi = Int.MAX_VALUE
    for (row in matrix) {
      for (v in row) {
        (s += abs(v.toDouble())).toLong()
        mi = min(mi.toDouble(), abs(v.toDouble())).toInt()
        if (v < 0) {
          ++cnt
        }
      }
    }
    return if (cnt % 2 == 0 || mi == 0) {
      s
    } else s - mi * 2
  }
}
