import kotlin.math.max
import kotlin.math.min

internal class Solution {
  fun maxAbsValExpr(arr1: IntArray, arr2: IntArray): Int {
    val dirs = intArrayOf(1, -1, -1, 1, 1)
    val inf = 1 shl 30
    var ans = -inf
    val n = arr1.size
    for (k in 0..3) {
      val a = dirs[k]
      val b = dirs[k + 1]
      var mx = -inf
      var mi = inf
      for (i in 0 until n) {
        mx = max(mx.toDouble(), (a * arr1[i] + b * arr2[i] + i).toDouble()).toInt()
        mi = min(mi.toDouble(), (a * arr1[i] + b * arr2[i] + i).toDouble()).toInt()
        ans = max(ans.toDouble(), (mx - mi).toDouble()).toInt()
      }
    }
    return ans
  }
}
