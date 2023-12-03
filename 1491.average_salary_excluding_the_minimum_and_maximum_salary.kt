import kotlin.math.max
import kotlin.math.min

class Solution {
  fun average(salary: IntArray): Double {
    var s = 0
    var mi = 10000000
    var mx = 0
    for (v in salary) {
      mi = min(mi.toDouble(), v.toDouble()).toInt()
      mx = max(mx.toDouble(), v.toDouble()).toInt()
      s += v
    }
    s -= mi + mx
    return s * 1.0 / (salary.size - 2)
  }
}
