internal class Solution {
  fun minCost(startPos: IntArray, homePos: IntArray, rowCosts: IntArray, colCosts: IntArray): Int {
    val i = startPos[0]
    val j = startPos[1]
    val x = homePos[0]
    val y = homePos[1]
    var ans = 0
    if (i < x) {
      for (k in i + 1..x) {
        ans += rowCosts[k]
      }
    } else {
      for (k in x until i) {
        ans += rowCosts[k]
      }
    }
    if (j < y) {
      for (k in j + 1..y) {
        ans += colCosts[k]
      }
    } else {
      for (k in y until j) {
        ans += colCosts[k]
      }
    }
    return ans
  }
}
