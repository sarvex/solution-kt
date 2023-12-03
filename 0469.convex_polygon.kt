internal class Solution {
  fun isConvex(points: List<List<Int?>>): Boolean {
    val n: Int = points.size()
    var pre: Long = 0
    var cur: Long = 0
    for (i in 0 until n) {
      val p1: Unit = points[i]
      val p2: Unit = points[(i + 1) % n]
      val p3: Unit = points[(i + 2) % n]
      val x1: Int = p2.get(0) - p1.get(0)
      val y1: Int = p2.get(1) - p1.get(1)
      val x2: Int = p3.get(0) - p1.get(0)
      val y2: Int = p3.get(1) - p1.get(1)
      cur = (x1 * y2 - x2 * y1).toLong()
      if (cur != 0L) {
        if (cur * pre < 0) {
          return false
        }
        pre = cur
      }
    }
    return true
  }
}
