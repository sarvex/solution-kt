internal class Solution {
  fun isRectangleOverlap(rec1: IntArray, rec2: IntArray): Boolean {
    val x1 = rec1[0]
    val y1 = rec1[1]
    val x2 = rec1[2]
    val y2 = rec1[3]
    val x3 = rec2[0]
    val y3 = rec2[1]
    val x4 = rec2[2]
    val y4 = rec2[3]
    return !(y3 >= y2 || y4 <= y1 || x3 >= x2 || x4 <= x1)
  }
}
