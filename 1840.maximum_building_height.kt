import kotlin.math.max
import kotlin.math.min

class Solution {
  fun maxBuilding(n: Int, restrictions: Array<IntArray?>?): Int {
    val r: List<IntArray> = ArrayList()
    r.addAll(Arrays.asList(restrictions))
    r.add(intArrayOf(1, 0))
    Collections.sort(r) { a, b -> a.get(0) - b.get(0) }
    if (r[r.size() - 1][0] !== n) {
      r.add(intArrayOf(n, n - 1))
    }
    val m: Int = r.size()
    for (i in 1 until m) {
      val a = r[i - 1]
      val b = r[i]
      b[1] = min(b[1].toDouble(), (a[1] + b[0] - a[0]).toDouble()).toInt()
    }
    for (i in m - 2 downTo 1) {
      val a = r[i]
      val b = r[i + 1]
      a[1] = min(a[1].toDouble(), (b[1] + b[0] - a[0]).toDouble()).toInt()
    }
    var ans = 0
    for (i in 0 until m - 1) {
      val a = r[i]
      val b = r[i + 1]
      val t = (a[1] + b[1] + b[0] - a[0]) / 2
      ans = max(ans.toDouble(), t.toDouble()).toInt()
    }
    return ans
  }
}
