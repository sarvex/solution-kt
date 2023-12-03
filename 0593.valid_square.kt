internal class Solution {
  fun validSquare(p1: IntArray, p2: IntArray, p3: IntArray, p4: IntArray): Boolean {
    return check(p1, p2, p3) && check(p1, p3, p4) && check(p1, p2, p4) && check(p2, p3, p4)
  }

  private fun check(a: IntArray, b: IntArray, c: IntArray): Boolean {
    val x1 = a[0]
    val y1 = a[1]
    val x2 = b[0]
    val y2 = b[1]
    val x3 = c[0]
    val y3 = c[1]
    val d1 = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)
    val d2 = (x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3)
    val d3 = (x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3)
    if (d1 == d2 && d1 + d2 == d3 && d1 > 0) {
      return true
    }
    if (d1 == d3 && d1 + d3 == d2 && d1 > 0) {
      return true
    }
    return if (d2 == d3 && d2 + d3 == d1 && d2 > 0) {
      true
    } else false
  }
}
