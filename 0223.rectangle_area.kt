import kotlin.math.max
import kotlin.math.min

internal class Solution {
  fun computeArea(ax1: Int, ay1: Int, ax2: Int, ay2: Int, bx1: Int, by1: Int, bx2: Int, by2: Int): Int {
    val a = (ax2 - ax1) * (ay2 - ay1)
    val b = (bx2 - bx1) * (by2 - by1)
    val width = (min(ax2.toDouble(), bx2.toDouble()) - max(ax1.toDouble(), bx1.toDouble())).toInt()
    val height = (min(ay2.toDouble(), by2.toDouble()) - max(ay1.toDouble(), by1.toDouble())).toInt()
    return (a + b - max(height.toDouble(), 0.0) * max(width.toDouble(), 0.0)).toInt()
  }
}
