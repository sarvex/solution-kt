internal class Solution {
  fun countNumbersWithUniqueDigits(n: Int): Int {
    if (n == 0) {
      return 1
    }
    if (n == 1) {
      return 10
    }
    var ans = 10
    var i = 0
    var cur = 9
    while (i < n - 1) {
      cur *= 9 - i
      ans += cur
      ++i
    }
    return ans
  }
}
