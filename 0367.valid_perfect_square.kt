internal class Solution {
  fun isPerfectSquare(num: Int): Boolean {
    var left: Long = 1
    var right = num.toLong()
    while (left < right) {
      val mid = left + right ushr 1
      if (mid * mid >= num) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    return left * left == num.toLong()
  }
}
