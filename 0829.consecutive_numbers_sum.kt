internal class Solution {
  fun consecutiveNumbersSum(n: Int): Int {
    var n = n
    n = n shl 1
    var ans = 0
    var k = 1
    while (k * (k + 1) <= n) {
      if (n % k == 0 && (n / k + 1 - k) % 2 == 0) {
        ++ans
      }
      ++k
    }
    return ans
  }
}
