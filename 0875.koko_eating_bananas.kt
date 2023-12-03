internal class Solution {
  fun minEatingSpeed(piles: IntArray, h: Int): Int {
    var left = 1
    var right = 1e9.toInt()
    while (left < right) {
      val mid = left + right ushr 1
      var s = 0
      for (x in piles) {
        s += (x + mid - 1) / mid
      }
      if (s <= h) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left
  }
}
