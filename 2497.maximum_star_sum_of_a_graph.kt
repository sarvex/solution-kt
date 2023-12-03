import kotlin.math.max

class Solution {
  fun maxStarSum(vals: IntArray, edges: Array<IntArray>, k: Int): Int {
    val n = vals.size
    val g: Array<List<Int>?> = arrayOfNulls(n)
    Arrays.setAll(g) { key -> ArrayList() }
    for (e in edges) {
      val a = e[0]
      val b = e[1]
      if (vals[b] > 0) {
        g[a].add(vals[b])
      }
      if (vals[a] > 0) {
        g[b].add(vals[a])
      }
    }
    for (e in g) {
      Collections.sort(e) { a, b -> b - a }
    }
    var ans = Int.MIN_VALUE
    for (i in 0 until n) {
      var v = vals[i]
      for (j in 0 until Math.min(g[i]!!.size(), k)) {
        v += g[i]!![j]
      }
      ans = max(ans.toDouble(), v.toDouble()).toInt()
    }
    return ans
  }
}
