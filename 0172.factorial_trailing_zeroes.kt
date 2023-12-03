internal class Solution {
  fun trailingZeroes(n: Int): Int {
    var n = n
    var ans = 0
    while (n > 0) {
      n /= 5
      ans += n
    }
    return ans
  }
}
