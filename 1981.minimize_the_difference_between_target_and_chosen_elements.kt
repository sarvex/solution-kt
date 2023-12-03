import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class Solution {
  fun minimizeTheDifference(mat: Array<IntArray>, target: Int): Int {
    var f = booleanArrayOf(true)
    for (row in mat) {
      var mx = 0
      for (x in row) {
        mx = max(mx.toDouble(), x.toDouble()).toInt()
      }
      val g = BooleanArray(f.size + mx)
      for (x in row) {
        for (j in x until f.size + x) {
          g[j] = g[j] or f[j - x]
        }
      }
      f = g
    }
    var ans = 1 shl 30
    for (j in f.indices) {
      if (f[j]) {
        ans = min(ans.toDouble(), abs((j - target).toDouble())).toInt()
      }
    }
    return ans
  }
}
