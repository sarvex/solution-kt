class Solution {
  fun countRectangles(rectangles: Array<IntArray>, points: Array<IntArray>): IntArray {
    val n = 101
    val d: Array<List<Int>?> = arrayOfNulls(n)
    Arrays.setAll(d) { k -> ArrayList() }
    for (r in rectangles) {
      d[r[1]].add(r[0])
    }
    for (v in d) {
      Collections.sort(v)
    }
    val m = points.size
    val ans = IntArray(m)
    for (i in 0 until m) {
      val x = points[i][0]
      val y = points[i][1]
      var cnt = 0
      for (h in y until n) {
        val xs = d[h]
        var left = 0
        var right: Int = xs!!.size()
        while (left < right) {
          val mid = left + right shr 1
          if (xs[mid] >= x) {
            right = mid
          } else {
            left = mid + 1
          }
        }
        cnt += xs.size() - left
      }
      ans[i] = cnt
    }
    return ans
  }
}
