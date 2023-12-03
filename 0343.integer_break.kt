internal class Solution {
  fun integerBreak(n: Int): Int {
    if (n < 4) {
      return n - 1
    }
    if (n % 3 == 0) {
      return 3.pow((n / 3).toDouble()) as Int
    }
    return if (n % 3 == 1) {
      3.pow((n / 3 - 1).toDouble()) as Int * 4
    } else 3.pow((n / 3).toDouble()) as Int * 2
  }
}
