class Solution {
  fun countPoints(points: Array<IntArray>, queries: Array<IntArray>): IntArray {
    val m = queries.size
    val ans = IntArray(m)
    for (k in 0 until m) {
      val x = queries[k][0]
      val y = queries[k][1]
      val r = queries[k][2]
      for (p in points) {
        val i = p[0]
        val j = p[1]
        val dx = i - x
        val dy = j - y
        if (dx * dx + dy * dy <= r * r) {
          ++ans[k]
        }
      }
    }
    return ans
  }
}
