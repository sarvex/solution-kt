internal class Solution {
  fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
    val x1 = coordinates[0][0]
    val y1 = coordinates[0][1]
    val x2 = coordinates[1][0]
    val y2 = coordinates[1][1]
    for (i in 2 until coordinates.size) {
      val x = coordinates[i][0]
      val y = coordinates[i][1]
      if ((x - x1) * (y2 - y1) != (y - y1) * (x2 - x1)) {
        return false
      }
    }
    return true
  }
}
