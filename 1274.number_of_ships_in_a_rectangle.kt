/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 * public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */
internal class Solution {
  fun countShips(sea: Sea, topRight: IntArray, bottomLeft: IntArray): Int {
    val x1 = bottomLeft[0]
    val y1 = bottomLeft[1]
    val x2 = topRight[0]
    val y2 = topRight[1]
    if (x1 > x2 || y1 > y2) {
      return 0
    }
    if (!sea.hasShips(topRight, bottomLeft)) {
      return 0
    }
    if (x1 == x2 && y1 == y2) {
      return 1
    }
    val midx = x1 + x2 shr 1
    val midy = y1 + y2 shr 1
    val a = countShips(sea, topRight, intArrayOf(midx + 1, midy + 1))
    val b = countShips(sea, intArrayOf(midx, y2), intArrayOf(x1, midy + 1))
    val c = countShips(sea, intArrayOf(midx, midy), bottomLeft)
    val d = countShips(sea, intArrayOf(x2, midy), intArrayOf(midx + 1, y1))
    return a + b + c + d
  }
}
