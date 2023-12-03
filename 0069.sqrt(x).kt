internal class Solution {
  fun mySqrt(x: Int): Int {
    var left = 0
    var right = x
    while (left < right) {
      val mid = left + right + 1 ushr 1
      if (mid <= x / mid) {
        // mid*mid <= x
        left = mid
      } else {
        right = mid - 1
      }
    }
    return left
  }
}
